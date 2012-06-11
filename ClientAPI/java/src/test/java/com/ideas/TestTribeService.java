package com.ideas;

import com.ideas.api.client.services.members.MembersServices;
import com.ideas.api.client.services.members.TribeServices;
import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.members.Person;
import org.goodtech.tribes.tribes.Tribe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
 * Created 6/11/12 12:16 PM
 */
public class TestTribeService
{

    @Test
    public void testGetWithId ()
    {
        TribeServices services = new TribeServices();

        Tribe tribe = services.getTribeWithId(12L);

        assertEquals(tribe.getName(), "Kona Golf Club");


    }

}
