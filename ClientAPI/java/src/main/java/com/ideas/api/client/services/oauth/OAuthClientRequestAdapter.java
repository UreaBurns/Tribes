package com.ideas.api.client.services.oauth;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.ClientConfiguration;
import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.common.exception.OAuthSystemException;

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
 * Created 6/24/12 10:15 AM
 */
public class OAuthClientRequestAdapter
{
    private OAuthClientRequest oAuthClientRequest;

    public OAuthClientRequestAdapter()
    {
        try {
            oAuthClientRequest = OAuthClientRequest
                                                   .authorizationLocation(ClientConfiguration.getBaseRequestURI() + "/oauth/initiate")
                                                   .setClientId(ClientConfiguration.getClientID())
                                                   .setRedirectURI(ClientConfiguration.getBaseRequestURI() + "/oauth/redirect")
                                                   .buildQueryMessage();

        }
        catch (OAuthSystemException e) {
            e.printStackTrace();
        }
    }

    public OAuthClientRequest getoAuthClientRequest()
    {
        return oAuthClientRequest;
    }

    public void setoAuthClientRequest(OAuthClientRequest oAuthClientRequest)
    {
        this.oAuthClientRequest = oAuthClientRequest;
    }
}
