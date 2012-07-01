package com.ideas.api.client;

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
 * Created 6/24/12 10:02 AM
 */
public class ClientConfiguration
{

    private static ClientConfiguration instance = new ClientConfiguration();

    private ClientConfiguration()
    {
//        setBaseRequestURI("http://coreapi.net:8080/SNAPSHOTS/stage");
        setBaseRequestURI("http://localhost:8083/ServerAPI");
        setRequestTimeout(20000);
        setClientID("development-client");

    }

    private static String baseRequestURI;
    private static String clientSecret;
    private static String clientID;
    private static int requestTimeout;

    public static String getBaseRequestURI()
    {
        return baseRequestURI;
    }

    public static void setBaseRequestURI(String baseRequestURI)
    {
        ClientConfiguration.baseRequestURI = baseRequestURI;
    }

    public static String getClientSecret()
    {
        return clientSecret;
    }

    public static void setClientSecret(String clientSecret)
    {
        ClientConfiguration.clientSecret = clientSecret;
    }

    public static String getClientID()
    {
        return clientID;
    }

    public static void setClientID(String clientID)
    {
        ClientConfiguration.clientID = clientID;
    }

    public static int getRequestTimeout()
    {
        return requestTimeout;
    }

    public static void setRequestTimeout(int requestTimeout)
    {
        ClientConfiguration.requestTimeout = requestTimeout;
    }
}
