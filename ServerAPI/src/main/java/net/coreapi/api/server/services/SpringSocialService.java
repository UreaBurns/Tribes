package net.coreapi.api.server.services;

import org.goodtech.tribes.members.Member;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
 * Created 6/9/12 9:42 AM
 */

@Path("/spring-social")
@Produces(MediaType.APPLICATION_JSON)
public class SpringSocialService
{

    @GET
    @Path("/get-with-id:{id}")
    public APIResponse set (@PathParam("id") Long id)
    {
        Member member = new Member();
        member.setId(id);

        APIResponse apiResponse = new APIResponse(member, 200);
        return apiResponse;
    }
}
