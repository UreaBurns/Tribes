package com.ideas;

import com.ideas.api.client.services.members.MembersServices;
import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.members.Person;
import org.junit.Test;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Test the ideas service endpoints.
 */
public class TestMembersService
{

    /**
     * Test getting an idea by ID
     */
    @Test
    public void testGetWithId ()
    {
        MembersServices server = new MembersServices();
        Member member = server.getWithId(12);

        assertEquals(
                "Asserting that the ID of the returned idea is equal to the ID requested.",
                (Long)12L,
                member.getId()
        );
    }

    @Test
    public void testGetMemberOfTypeWithId ()
    {
        MembersServices services = new MembersServices();
        Person person = services.getPersonWithMemberId(12L);
        Member member = services.getWithId(12L);
        Boolean memberMatchesPerson = person.getId().equals(member.getId());

        assertTrue(memberMatchesPerson);
    }

}
