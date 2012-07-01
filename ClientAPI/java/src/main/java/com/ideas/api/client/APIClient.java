package com.ideas.api.client;

import com.ideas.api.client.services.ResponseError;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * API Client to that will make requests to APIs.
 */
public class APIClient
{

    private static final APIClient instance = new APIClient();

    public static APIClient getInstance()
    {
        return instance;
    }

    private APIClient()
    {

    }


    /**
     * Make an API request.
     *
     * @param request The request to make.
     * @return The response from the API.
     */
    public <ResponseEntity> APIResponse makeRequest(APIRequest request)
    {
        APIResponse apiResponse = null;

        // Establish a client collection.
        HttpClient httpclient = new DefaultHttpClient();
        HttpParams clientParams = httpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(clientParams,
                                                  ClientConfiguration.getRequestTimeout());
        HttpConnectionParams.setSoTimeout(clientParams,
                                          ClientConfiguration.getRequestTimeout());

        // TODO move http client connection creation out of this method.
        // TODO author a generic configuration entity. Hydrate it from a config file.

        HttpRequestBase requestBase = getRequestBaseForRequest(request);

        Iterator<String> keySetIterator = request.getRequestParametersMap().keySet().iterator();

        while (keySetIterator.hasNext())
        {
            String key = keySetIterator.next();
            clientParams.setParameter(key,
                                      request.getRequestParametersMap().get(key));
        }



        requestBase.setParams(clientParams);

        HttpResponse response = null;
        try
        {
            response = httpclient.execute(requestBase);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if (null != response)
        {
            HttpEntity resEntity = response.getEntity();

            try
            {
                String responseText = EntityUtils.toString(resEntity);

                if (null == responseText || responseText.isEmpty())
                {
                    responseText = "{\"status\":404, \"response\":{\"message\":\"Resource not found.\"}}";
                }

                try
                {
                    apiResponse = JSONObjectMapper.<APIResponse>mapJSONStringToEntity(responseText,
                                                                                      APIResponse.class);
                }
                catch (InvalidJSONStringException e)
                {
                    responseText = "{\"status\":500, \"response\":{\"message\":\"Invalid JSON was returned from server.\"}}";
                    apiResponse = JSONObjectMapper.<APIResponse>mapJSONStringToEntity(responseText,
                                                                                      APIResponse.class);
                    e.printStackTrace();
                }
                apiResponse.setRawResponseString(responseText);

                //                System.out.println(apiResponse.getRawResponseString());


                ResponseEntity responseEntity = (ResponseEntity) JSONObjectMapper.mapJSONNodeStringToEntity(responseText,
                                                                                                            "response",
                                                                                                            request.getRequestEntityClass());

                apiResponse.setResponse(responseEntity);
                try
                {
                    handleResponseCode(apiResponse);
                }
                catch (ResponseError e)
                {
                    e.printStackTrace();
                }
            }
            catch (Throwable e)
            {
                e.printStackTrace();
                // NOP
            }

        }

        return apiResponse;
    }

    private void handleResponseCode(APIResponse apiResponse) throws ResponseError
    {
        if (apiResponse.getStatus() != 200)
        {
            throw new ResponseError(apiResponse.getStatus() + "");
        }
    }

    /**
     * Get the request base for the requests request type.
     *
     * @param request The request.
     * @return The request base.
     * @todo Reduce complexity.
     */
    private HttpRequestBase getRequestBaseForRequest(APIRequest request)
    {
        if (request.getRequestType().equals(RequestType.GET))
        {
            return new HttpGet(request.getRequestUrl().toString());
        }
        else if (request.getRequestType().equals(RequestType.JSON_POST))
        {
            HttpPost post = new HttpPost(request.getRequestUrl().toString());
            post.setHeader("Content-type",
                           "application/json");
            try
            {
                String requestJSON = JSONObjectMapper.convertEntityToJSON(request.getRequestEntity());
                post.setEntity(new StringEntity(requestJSON,
                                                "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
            catch (FatalMappingException e)
            {
                e.printStackTrace();
            }

            return post;
        }
        else if (request.getRequestType().equals(RequestType.POST))
        {
            HttpPost httpPost = new HttpPost(request.getRequestUrl().toString());
            httpPost.setHeader("Content-type",
                               "application/x-www-form-urlencoded");

            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

            Iterator<String> requestParametersMapKeySetIterator = request.getRequestParametersMap().keySet().iterator();

            String parameterKey;
            while (requestParametersMapKeySetIterator.hasNext())
            {
                parameterKey = requestParametersMapKeySetIterator.next();
                nameValuePairs.add(new BasicNameValuePair(parameterKey,
                                                          request.getRequestParametersMap().get(parameterKey)));
            }

            boolean needsSigned = request.getRequestParametersMap().containsKey("oauth_callback");

            if (needsSigned) {

                int millis = (int) System.currentTimeMillis() * -1;
                int time = (int) millis / 1000;

                /**
                 * Listing of all parameters necessary to retrieve a token
                 * (sorted lexicographically as demanded)
                 */
                 String[][] data = {
                    {"oauth_callback", request.getRequestParametersMap().get("oauth_callback")},
                    {"oauth_consumer_key", request.getRequestParametersMap().get("oauth_consumer_key")},
//                    {"oauth_nonce",  String.valueOf(millis)},
                    {"oauth_nonce",  String.valueOf(millis)},
                    {"oauth_signature", ""},
                    {"oauth_signature_method", "HMAC-SHA1"},
//                    {"oauth_timestamp", String.valueOf(time)},
                    {"oauth_timestamp", String.valueOf(time)},
                    {"oauth_version", "1.0"}
                };

                try {
                    /**
                     * Generation of the signature base string
                     */
                    String signature_base_string =
                            "POST&"+URLEncoder.encode(request.getRequestUrl().toString(), "UTF-8")+"&";

                    for(int i = 0; i < data.length; i++) {
                        // ignore the empty oauth_signature field
                        if(i != 3) {
                            signature_base_string +=
                                    URLEncoder.encode(data[i][0],
                                                      "UTF-8") + "%3D" +
                                            URLEncoder.encode(data[i][1], "UTF-8") + "%26";
                        }
                    }

                    // cut the last appended %26
                    signature_base_string = signature_base_string.substring(0,
                                                                            signature_base_string.length()-3);

                    String signature = computeSignature(signature_base_string, "key");

                    nameValuePairs.add(new BasicNameValuePair("oauth_signature", signature));

                }
                catch (Throwable e) {
                    e.printStackTrace();
                }


                requestParametersMapKeySetIterator = request.getRequestParametersMap().keySet().iterator();
                while (requestParametersMapKeySetIterator.hasNext())
                {
                    parameterKey = requestParametersMapKeySetIterator.next();
                    nameValuePairs.add(new BasicNameValuePair(parameterKey,
                                                              request.getRequestParametersMap().get(parameterKey)));
                }

                try {
                    computeSignature("asdf", request.getRequestParametersMap().get("oauth_consumer_key"));
                }
                catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }


            try
            {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                //                httpPost.setEntity(new StringEntity(request.getRequestParametersMap().get(APIRequest.JSON_DATA),
                //                                                    "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
            return httpPost;
        }
        else
        {
            return new HttpGet(request.getRequestUrl().toString());
        }
    }

    private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException
    {

        SecretKey secretKey = null;

        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");

        mac.init(secretKey);

        byte[] text = baseString.getBytes();

        return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
    }
}
