package net.coreapi.api.server.auth.oauth2;

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
 * Created 6/20/12 10:43 PM
 */
public class AuthorizationRequest
{
    //        oauth_signature ="%2BJfoxyJ6H5S2k4bwIZg0vaTovfI%3D",
    //        oauth_nonce="09b10c5b-f815-4807-b92c-f6a8dcaef583",
    //        oauth_signature_method="HMAC-SHA1",
    //        oauth_consumer_key="http%3A%2F%2Flocalhost%3A8080%2FTokenService%2Fresources%2Foauth%2Fv1%2Fconsumer%2FStockClient",
    //        oauth_timestamp="1247685651"
    private String oauth_signature, oauth_nounce, oauth_signature_method, oauth_consumer_key, oauth_timestamp, oauth_callback, oauth_version;

    public String getOauth_signature()
    {
        return oauth_signature;
    }

    public void setOauth_signature(String oauth_signature)
    {
        this.oauth_signature = oauth_signature;
    }

    public String getOauth_nounce()
    {
        return oauth_nounce;
    }

    public void setOauth_nounce(String oauth_nounce)
    {
        this.oauth_nounce = oauth_nounce;
    }

    public String getOauth_signature_method()
    {
        return oauth_signature_method;
    }

    public void setOauth_signature_method(String oauth_signature_method)
    {
        this.oauth_signature_method = oauth_signature_method;
    }

    public String getOauth_consumer_key()
    {
        return oauth_consumer_key;
    }

    public void setOauth_consumer_key(String oauth_consumer_key)
    {
        this.oauth_consumer_key = oauth_consumer_key;
    }

    public String getOauth_timestamp()
    {
        return oauth_timestamp;
    }

    public void setOauth_timestamp(String oauth_timestamp)
    {
        this.oauth_timestamp = oauth_timestamp;
    }

    public String getOauth_callback()
    {
        return oauth_callback;
    }

    public void setOauth_callback(String oauth_callback)
    {
        this.oauth_callback = oauth_callback;
    }

    public String getOauth_version()
    {
        return oauth_version;
    }

    public void setOauth_version(String oauth_version)
    {
        this.oauth_version = oauth_version;
    }
}