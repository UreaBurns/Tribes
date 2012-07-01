package com.ideas.api.client.services.members;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.ClientConfiguration;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.entities.AuthorizationRequest;
import com.ideas.api.client.entities.OAuth;
import com.ideas.api.client.services.BaseService;
import com.ideas.api.client.services.oauth.OAuthClientRequestAdapter;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.JSONObjectMapper;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.common.exception.OAuthSystemException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.entity.StringEntity;
import org.goodtech.tribes.messages.Message;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Map;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 6/20/12 10:45 PM
 */
public class OAuth2Services extends BaseService
{
    public OAuth2Services login(AuthorizationRequest authorizationRequest)
    {
//
//        OAuthClientRequestAdapter oAuthClientRequestAdapter = new OAuthClientRequestAdapter();
//
//        String asdf = oAuthClientRequestAdapter.getoAuthClientRequest().getLocationUri();
//



        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.POST);
        apiRequest.setRequestUrl("/oauth/initiate");
        apiRequest.setRequestEntityClass(OAuth2Services.class);
        apiRequest.setRequestEntity(authorizationRequest);

        addRequestParametersForAuthorizationRequest(apiRequest, authorizationRequest);
//
//        try{
//            apiRequest.addRequestParameter("JSON_DATA",
//                                           JSONObjectMapper.convertEntityToJSON(authorizationRequest));
//
//        }
//        catch (FatalMappingException e) {
//            e.printStackTrace();
//        }



        APIResponse apiResponse = getAPIClient().makeRequest(apiRequest);

        return (OAuth2Services) apiResponse.getResponse();
    }

    public APIRequest addRequestParametersForAuthorizationRequest (APIRequest request, AuthorizationRequest authorizationRequest) {
        request.addRequestParameter("oauth_nonce", authorizationRequest.getOauth_nounce());
        request.addRequestParameter("oauth_signature_method", authorizationRequest.getOauth_signature_method());
        request.addRequestParameter("oauth_consumer_key", authorizationRequest.getOauth_consumer_key());
        request.addRequestParameter("oauth_timestamp", authorizationRequest.getOauth_timestamp());
        request.addRequestParameter("oauth_callback", authorizationRequest.getOauth_callback());


//        Map<String, String> requestParameterMap = request.getRequestParametersMap();
//
//
//        Iterator<String> keySetIterator = requestParameterMap.keySet().iterator();
//
//        StringBuilder requestSignature = new StringBuilder();
//
//        while (keySetIterator.hasNext())
//        {
//            String key = keySetIterator.next();
//            requestSignature.append(key + "=" + requestParameterMap.get(key) + );
//            clientParams.setParameter(key,
//                                      request.getRequestParametersMap().get(key));
//        }


        request.addRequestParameter("oauth_signature", authorizationRequest.getOauth_signature());
        return request;
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
