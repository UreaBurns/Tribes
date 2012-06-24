package com.ideas.api.client.services.members;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.apache.http.entity.StringEntity;
import org.goodtech.tribes.messages.Message;

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
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.JSON_POST);
        apiRequest.setRequestUrl("/auth/oauth2/login");
        apiRequest.setRequestEntityClass(OAuth2Services.class);
        apiRequest.setRequestEntity(authorizationRequest);
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

}
