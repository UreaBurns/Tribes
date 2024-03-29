package com.ideas.api.client.services.members;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.members.Person;

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
 * Created 6/9/12 4:15 PM
 */
public class MembersServices extends BaseService
{
    /**
     * Get a member with it's ID.
     *
     * @param id The ID of the idea.
     * @return The requested idea.
     */
    public Member getWithId(long id)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(MembersMethods.GET);
        apiRequest.setRequestEntityClass(Member.class);
        apiRequest.addRequestParameter(
                "id",
                Long.toString(id)
        );

        APIResponse apiResponse = getAPIClient().<Member>makeRequest(apiRequest);

        return (Member)apiResponse.getResponse();
    }

    public Person getPersonWithMemberId(long id)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(MembersMethods.GET_MEMBER_OF_TYPE);
        apiRequest.setRequestEntityClass(Person.class);
        apiRequest.addRequestParameter(
                "id",
                Long.toString(id)
        );

        apiRequest.addRequestParameter(
                "type",
                "person"
        );

        APIResponse apiResponse = getAPIClient().makeRequest(apiRequest);

        return (Person)apiResponse.getResponse();
    }
}
