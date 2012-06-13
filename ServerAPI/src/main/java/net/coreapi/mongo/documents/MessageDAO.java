package net.coreapi.mongo.documents;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.scottbyrns.mongo.MongoEntityMapper;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.codehaus.jackson.map.JsonMappingException;
import org.goodtech.tribes.members.Member;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.messages.MessageList;

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
 * Created 6/11/12 8:10 PM
 */
public class MessageDAO
{

    private static final String DATABASE_NAME = "TribesDatabase";
    private static final String COLLECTION_NAME = "TribesMessages";

    public void sendMessage (Message message) throws Exception {



        DBCollection dbCollection = ManagedMongoDriver.getInstance().getCollection(DATABASE_NAME, COLLECTION_NAME);



        try {
            DBObject dbObject = MongoEntityMapper.entityToDBObject(message);
            dbCollection.insert(dbObject);
        }
        catch (FatalMappingException e) {
            throw new Exception("Failed to send message.");
        }
    }

    public Message getMessageById (long id) throws Exception {
        DBCollection dbCollection = ManagedMongoDriver.getInstance().getCollection(DATABASE_NAME, COLLECTION_NAME);
        BasicDBObject query = new BasicDBObject();
        BasicDBObject field = new BasicDBObject();
        field.put("id", id);

        DBCursor cursor = dbCollection.find(field);
        if (cursor.hasNext()) {
            try {
                DBObject dbObject = cursor.next();

                Message message = MongoEntityMapper.dbObjectToEntity(dbObject, Message.class);
                return message;
            }
            catch (InvalidJSONStringException e) {
                throw new Exception("Record is corrupt.");
            }
            catch (FatalMappingException e) {
                throw new Exception("Record is corrupt.");
            }
        }
        throw new Exception("No record found.");
    }

    public MessageList getMessagesForMember (long id) throws Exception {
        DBCollection dbCollection = ManagedMongoDriver.getInstance().getCollection(DATABASE_NAME, COLLECTION_NAME);
        BasicDBObject query = new BasicDBObject();
        BasicDBObject field = new BasicDBObject();
        field.put("destination.id", id);

        MessageList messageList = new MessageList();
        messageList.setMessageList(new ArrayList<Message>());


        DBCursor cursor = dbCollection.find(field);
        while (cursor.hasNext()) {
            try {
                DBObject dbObject = cursor.next();
                Message message = MongoEntityMapper.dbObjectToEntity(dbObject, Message.class);
                messageList.getMessageList().add(message);
//                return message;
            }
            catch (InvalidJSONStringException e) {
                throw new Exception("Record is corrupt.");
            }
            catch (FatalMappingException e) {
                throw new Exception("Record is corrupt.");
            }
        }
//        throw new Exception("No record found.");
        return messageList;
    }

}
