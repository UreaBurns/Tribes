package net.coreapi.api.server.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.handler.MessageContext;

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
 * Created 6/20/12 9:48 AM
 */

@Path("/auth/oauth2")
@Produces(MediaType.APPLICATION_JSON)
public class OAuth2Service extends BaseService
{

    @Context
    private MessageContext context;

    @GET
    @Path("/error")
    public APIResponse error ()
    {
        return createErrorResponse(401, "Failed to authenticate.");
    }

    @GET
    @Path("/login")
    public APIResponse login ()
    {
        return createErrorResponse(200, "Log in.");
    }

    @GET
    @Path("/login-processing")
    public APIResponse loginProcessing ()
    {
        return createErrorResponse(200, "Log in processing.");
    }

    @GET
    @Path("/login-success")
    public APIResponse loginSuccess ()
    {
        return createErrorResponse(200, "Authenticated.");
    }

    @GET
    @Path("/logout")
    public APIResponse logout ()
    {
        return createErrorResponse(200, "Log in.");
    }

    @GET
    @Path("/logout-success")
    public APIResponse logoutSuccess ()
    {
        return createErrorResponse(200, "Logged out.");
    }

}

