package com.ideas;

import com.ideas.api.client.services.members.AuthorizationRequest;
import com.ideas.api.client.services.members.OAuth2Services;
import org.junit.Test;

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
 * Created 6/20/12 10:49 PM
 */
public class TestOAuth2Service
{
    @Test
    public void testLogin () {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        authorizationRequest.setOauth_consumer_key("consumer_key");
        authorizationRequest.setOauth_nounce("nounce");
        authorizationRequest.setOauth_signature("signature");
        authorizationRequest.setOauth_signature_method("signature_method");
        authorizationRequest.setOauth_timestamp("timestamp");
        new OAuth2Services().login(authorizationRequest);
    }
}