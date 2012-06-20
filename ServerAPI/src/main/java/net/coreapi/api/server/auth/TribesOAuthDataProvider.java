package net.coreapi.api.server.auth;

import org.apache.cxf.rs.security.oauth2.common.*;
import org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;

import java.util.Date;
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
 * Created 6/20/12 10:22 AM
 */
public class TribesOAuthDataProvider implements OAuthDataProvider
{

    private static final String MOCK_SECRET = "0FAC2312";
    private static final boolean IS_PRIVATE = true;

    public Client getClient(String clientId) throws OAuthServiceException
    {
        Client client = new Client(clientId, MOCK_SECRET, IS_PRIVATE);

        return client;
    }

    public ServerAccessToken createAccessToken(AccessTokenRegistration accessTokenRegistration) throws OAuthServiceException
    {
        ServerAccessToken serverAccessToken = new ServerAccessToken(accessTokenRegistration.getClient(), accessTokenRegistration.getGrantType(), MOCK_SECRET, new Date().getTime() + 5000, new Date().getTime()) {
            {
                System.out.println("ANONYMOUS SERVER ACCESS TOKEN CREATED @TODO DONT DO THIS");
            }
        };

        return serverAccessToken;
    }

    public ServerAccessToken getAccessToken(String s) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ServerAccessToken getPreauthorizedToken(Client client, UserSubject userSubject, String s) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ServerAccessToken refreshAccessToken(String s, String s1) throws OAuthServiceException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeAccessToken(ServerAccessToken serverAccessToken) throws OAuthServiceException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<OAuthPermission> convertScopeToPermissions(Client client, List<String> strings)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
