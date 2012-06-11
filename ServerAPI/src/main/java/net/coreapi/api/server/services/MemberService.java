package net.coreapi.api.server.services;

import net.coreapi.dao.LocationDAO;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.goodtech.statistics.NormalizedValue;
import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.members.Persona;
import org.goodtech.tribes.members.Personification;
import org.goodtech.tribes.tags.Tag;
import redis.clients.jedis.Jedis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
 * Created 6/8/12 11:48 AM
 */

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
public class MemberService
{

    @GET
    @Path("/get-with-id:{id}")
    public APIResponse set (@PathParam("id") Long id)
    {
        Member member = new Member();
        member.setId(12L);


        Persona persona = new Persona();
        LinkedHashMap<Tag, NormalizedValue> tagMap = new LinkedHashMap<Tag, NormalizedValue>();

        Tag tag = new Tag();
        tag.setId(1L);
        tag.setLabel("TestLabel");

        NormalizedValue normalizedValue = new NormalizedValue();
        normalizedValue.setValue(0.4);

        tagMap.put(tag, normalizedValue);

        List<Personification> personificationList = new ArrayList<Personification>();
        Personification personification = new Personification();
        personification.setTag(tag);
        personification.setNormalizedValue(normalizedValue);
        personificationList.add(personification);

        persona.setId(1L);
        persona.setPersonificationList(personificationList);

        member.setPersona(persona);

        APIResponse apiResponse = new APIResponse(member, 200);
        return apiResponse;
    }

}
