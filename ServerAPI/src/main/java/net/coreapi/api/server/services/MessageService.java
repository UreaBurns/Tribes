package net.coreapi.api.server.services;

import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.messages.Document;
import org.goodtech.tribes.messages.DocumentType;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.tribes.Tribe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
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
 * Created 6/11/12 1:02 PM
 */

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageService
{

    @Context
    private MessageContext context;

    @GET
    @Path("/get-latest-message-for-member-with-id:{id}")
    public APIResponse getWithId (@PathParam("id") Long id)
    {

        Member member = new Member();
        member.setId(id);

        Tribe tribe = new Tribe();
        tribe.setName("Kona Golf Club");
        tribe.setDescription("Miniature golf fanatics club.");
        tribe.setId(123L);

        Message message = new Message();
        message.setAudience(member);
        message.setPublisher(tribe);
        message.setContent("Golf club meetup tuesday!");

        DocumentType documentType = new DocumentType();
        documentType.setId(7);
        documentType.setName("Group Event");

        message.setDocumentType(documentType);

        DocumentType timeDocument = new DocumentType();
        timeDocument.setId(4);
        timeDocument.setName("Date and Time");

        Document document = new Document();
        document.setDocumentType(timeDocument);
        document.setContent("3:30PM Tuesday");
        document.setId(23122);

        List<Document> documentList = new ArrayList<Document>();
        documentList.add(document);

        message.setOrderedElements(documentList);


        APIResponse apiResponse = new APIResponse(message, 200);
        return apiResponse;
    }

}
