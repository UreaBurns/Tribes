package com.ideas.api.client;

import com.ideas.api.client.services.ResponseError;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

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

        // get a client connection
        HttpClient httpclient = new DefaultHttpClient();
        HttpParams clientParams = httpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(clientParams, 20000);
        HttpConnectionParams.setSoTimeout(clientParams, 20000);

        HttpRequestBase requestBase = getRequestBaseForRequest(request);

        Iterator<String> keySetIterator = request.getRequestParametersMap().keySet().iterator();

        while (keySetIterator.hasNext())
        {
            String key = keySetIterator.next();
            clientParams.setParameter(
                    key,
                    request.getRequestParametersMap().get(key)
            );
        }

        requestBase.setParams(clientParams);

        HttpResponse response = null;
        try
        {
            response = httpclient.execute(requestBase);
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (null != response)
        {
            HttpEntity resEntity = response.getEntity();

            try {
                String responseText = EntityUtils.toString(resEntity);

                if (null == responseText || responseText.isEmpty()) {
                    responseText = "{\"status\":404, \"response\":{\"message\":\"Resource not found.\"}}";
                }

                apiResponse = JSONObjectMapper.<APIResponse>mapJSONStringToEntity(responseText, APIResponse.class);

                apiResponse.setRawResponseString(responseText);

//                System.out.println(apiResponse.getRawResponseString());

                ResponseEntity responseEntity = (ResponseEntity)JSONObjectMapper.mapJSONNodeStringToEntity(responseText, "response", request.getRequestEntityClass());
                apiResponse.setResponse(
                        responseEntity
                                       );
                try {
                    handleResponseCode(apiResponse);
                }
                catch (ResponseError e) {
                    e.printStackTrace();
                }
            }
            catch (Throwable e) {
                e.printStackTrace();
                // NOP
            }

        }

        return apiResponse;
    }

    private void handleResponseCode (APIResponse apiResponse) throws ResponseError
    {
        if (apiResponse.getStatus() != 200) {
            throw new ResponseError(apiResponse.getStatus() + "");
        }
    }

    /**
     * Get the request base for the requests request type.
     *
     * @param request The request.
     * @return The request base.
     *
     * @todo Reduce complexity.
     */
    private HttpRequestBase getRequestBaseForRequest (APIRequest request)
    {
        if (request.getRequestType().equals(RequestType.GET))
        {
            return new HttpGet(request.getRequestUrl().toString());
        }
        else if (request.getRequestType().equals(RequestType.JSON_POST))
        {
            HttpPost post = new HttpPost(request.getRequestUrl().toString());
            post.setHeader("Content-type", "application/json");
            try
            {
                post.setEntity(
                        new StringEntity(
                                request.getRequestParametersMap().get(APIRequest.JSON_DATA),
                                "UTF-8"
                        )
                );
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }

            return post;
        }
        else if (request.getRequestType().equals(RequestType.POST))
        {
            return new HttpPost(request.getRequestUrl().toString());
        }
        else
        {
            return new HttpGet(request.getRequestUrl().toString());
        }
    }
}
