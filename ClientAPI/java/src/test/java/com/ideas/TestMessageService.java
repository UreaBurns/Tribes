package com.ideas;

import com.ideas.api.client.services.members.MessageServices;
import com.ideas.api.client.services.members.TribeServices;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.messages.MessageList;
import org.goodtech.tribes.tribes.Tribe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
 * Created 6/11/12 1:21 PM
 */
public class TestMessageService
{

    @Test
    public void testGetWithId ()
    {
        MessageServices services = new MessageServices();

        Message message = services.getLatestMessageForMemberWithId(13L);

        assertEquals(message.getDestination().getId(), (Long)13L);

    }

    @Test
    public void testGetAllMessagesForMemberWithId () {
        MessageServices services = new MessageServices();
        MessageList messageList = services.getAllMessagesForMemberWithId(13L);

        assertEquals(messageList.getMessageList().get(0).getDestination().getId(), (Long)13L);

    }

}
