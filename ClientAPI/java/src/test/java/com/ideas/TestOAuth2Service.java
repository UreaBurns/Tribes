package com.ideas;

import com.ideas.api.client.entities.AuthorizationRequest;
import com.ideas.api.client.services.members.OAuth2Services;
import net.smartam.leeloo.common.OAuth;
import net.smartam.leeloo.common.utils.OAuthUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

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
        authorizationRequest.setOauth_consumer_key("123456789");
        authorizationRequest.setOauth_nounce("e365fa02-772e-4e33-900d-00a766ccadf8");
        authorizationRequest.setOauth_signature("ztTQuqaJS7L6dNQwn%2Fqi1MdaqQQ%3D");
        authorizationRequest.setOauth_signature_method("HMAC-SHA1");
        authorizationRequest.setOauth_timestamp(Long.toString(System.currentTimeMillis() / 1000));
        authorizationRequest.setOauth_version("1.0");
        authorizationRequest.setOauth_callback("http://localhost:8083/ServerAPI/members/get-with-id:12");
        new OAuth2Services().login(authorizationRequest);
    }
}
