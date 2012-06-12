package com.geoapi.server;

import com.scottbyrns.utilities.JSONObjectMapper;
import net.coreapi.api.server.services.APIResponse;
import net.coreapi.api.server.services.HealthService;
import net.coreapi.api.server.services.MessageService;
import net.coreapi.api.server.services.ServerStatus;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.messages.MessageList;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

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
 * Created 6/12/12 1:35 AM
 */
public class TestMessageService
{
    @Test
    public void testGetWithId () {
        MessageService messageService = new MessageService();
        APIResponse apiResponse = messageService.getWithId(13L);

        try {
            String messageJSONString = apiResponse.toResponseString();
            Message message = JSONObjectMapper.mapJSONNodeStringToEntity(messageJSONString, "response", Message.class);
            assertEquals((Long)13L, (Long)message.getId());
        }
        catch (Throwable e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetAllMessagesForMemberById () {
        MessageService messageService = new MessageService();
        APIResponse apiResponse = messageService.getAllMessagesForMemberById(13L);
        try {
            MessageList messageList = JSONObjectMapper.<MessageList>mapJSONNodeStringToEntity(apiResponse.toResponseString(), "response", MessageList.class);


        try {

            assertEquals((Long)13L, (Long)messageList.getMessageList().get(0).getId());
        }
        catch (Throwable e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        }
        catch (Throwable e) {
            // NOP
        }

    }
}
