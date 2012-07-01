package net.coreapi.api.server.auth.oauth2;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.rs.security.oauth.data.*;
import org.apache.cxf.rs.security.oauth.provider.OAuthDataProvider;
import org.apache.cxf.rs.security.oauth.provider.OAuthServiceException;

import java.util.List;

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
 * Created 6/24/12 1:27 PM
 */
public class DefaultOAuthServiceProvider implements OAuthDataProvider
{
//   public Client registerClient(String applicationName, String applicationURI, ...) {}
//   public void removeClient(String cliendId) {}


    public org.apache.cxf.rs.security.oauth.data.Client getClient(String clientId) throws OAuthServiceException
    {
//        new org.apache.cxf.rs.security.oauth.data.Client(clientId, new OAuthClientsMemoryDAO().getConsumerSecretForClientId(clientId));
        return null;
    }

    public RequestToken createRequestToken(RequestTokenRegistration requestTokenRegistration) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RequestToken getRequestToken(String s) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String setRequestTokenVerifier(RequestToken requestToken) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AccessToken createAccessToken(RequestToken requestToken) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AccessToken getAccessToken(String s) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeToken(Token token) throws OAuthServiceException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<OAuthPermission> getPermissionsInfo(List<String> strings)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
