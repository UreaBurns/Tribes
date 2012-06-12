package net.coreapi.api.server.services;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.goodtech.statistics.NormalizedValue;
import org.goodtech.tribes.members.*;
import org.goodtech.tribes.tags.Tag;
import org.goodtech.tribes.tribes.Tribe;

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
 * Created 6/11/12 11:57 AM
 */
@Path("/tribe")
@Produces(MediaType.APPLICATION_JSON)
public class TribeService extends BaseService
{

    @Context
    private MessageContext context;

    @GET
    @Path("/get-with-id:{id}")
    public APIResponse getWithId(@PathParam("id") Long id)
    {

        Tribe tribe = new Tribe();
        tribe.setDescription("Golf Tribe");
        tribe.setName("Kona Golf Club");

        /* Creating a persona for the tribe. */
        Persona persona = new Persona();

        Tag shortGame = new Tag();
        shortGame.setId(1L);
        shortGame.setLabel("Short Game");

        Tag scramble = new Tag();
        scramble.setId(1L);
        scramble.setLabel("Scrambles");

        NormalizedValue normalizedValue = new NormalizedValue();
        normalizedValue.setValue(0.4);


        List<Personification> personificationList = new ArrayList<Personification>();
        Personification personification = new Personification();
        personification.setTag(shortGame);
        personification.setNormalizedValue(normalizedValue);
        personificationList.add(personification);

        personification = new Personification();
        personification.setTag(scramble);
        personification.setNormalizedValue(normalizedValue);
        personificationList.add(personification);

        persona.setId(1L);
        persona.setPersonificationList(personificationList);

        tribe.setPersona(persona);



        Member member = new Member();
        member.setId(id);
        member.setPersona(persona);

        Member secondMember = new Member();
        secondMember.setId(id + 1);
        secondMember.setPersona(persona);

        List<Member> memberList = new ArrayList<Member>();
        memberList.add(member);
        memberList.add(secondMember);


        Roster roster = new Roster();

        roster.setId(123L);

        List<RankedMember> rankedMembersList = new ArrayList<RankedMember>();

        RankedMember rankedMember = new RankedMember();
        rankedMember.setMember(member);
        rankedMember.setNormalizedValue(normalizedValue);
        rankedMember.setMember(secondMember);
        rankedMember.setNormalizedValue(normalizedValue);

        rankedMembersList.add(rankedMember);

        roster.setRankedMemberList(rankedMembersList);

        tribe.setMemberRoster(roster);

        APIResponse apiResponse;
        apiResponse = new APIResponse(tribe, 200);


        return apiResponse;

    }
}
