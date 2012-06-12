package com.ideas.api.client.services.members;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.messages.MessageList;
import org.goodtech.tribes.tribes.Tribe;

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
 * Created 6/11/12 1:21 PM
 */
public class MessageServices extends BaseService
{
    public Message getLatestMessageForMemberWithId(long id)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(MessageMethods.GET_LATEST_FOR_MEMBER_BY_ID);
        apiRequest.setRequestEntityClass(Message.class);
        apiRequest.addRequestParameter("id",
                                       Long.toString(id));

        APIResponse apiResponse = getAPIClient().makeRequest(apiRequest);

        return (Message) apiResponse.getResponse();
    }

    public MessageList getAllMessagesForMemberWithId(long id)
    {
        APIRequest apiRequest = createAPIRequest();
        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(MessageMethods.GET_ALL_MESSAGES_FOR_MEMBER_BY_ID);

        apiRequest.setRequestEntityClass(MessageList.class);

        apiRequest.addRequestParameter("id", Long.toString(id));

        APIResponse apiResponse = getAPIClient().makeRequest(apiRequest);

        return (MessageList) apiResponse.getResponse();

    }
    ///get-all-messages-for-member-with-id:{id}
}
