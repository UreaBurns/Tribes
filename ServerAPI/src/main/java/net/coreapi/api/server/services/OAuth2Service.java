package net.coreapi.api.server.services;

import com.scottbyrns.utilities.JSONObjectMapper;
import net.coreapi.api.server.auth.oauth2.AuthorizationRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
@Consumes(MediaType.APPLICATION_JSON)
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

    @POST
    @Path("/login")
//    @Consumes({"application/x-www-form-urlencoded"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public APIResponse login (String request)
    {

        AuthorizationRequest authorizationRequest = null;
        try {
            authorizationRequest = JSONObjectMapper.mapJSONStringToEntity(request, AuthorizationRequest.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        APIResponse apiResponse = createNewAPIResponse();
        apiResponse.setData(authorizationRequest);
        apiResponse.setStatus(200);
        return apiResponse;
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

