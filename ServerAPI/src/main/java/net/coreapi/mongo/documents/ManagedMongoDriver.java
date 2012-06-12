package net.coreapi.mongo.documents;

import com.mongodb.*;
import com.mongodb.util.JSON;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.goodtech.tribes.messages.Message;

import java.net.UnknownHostException;

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
 * Created 6/11/12 8:13 PM
 */
public class ManagedMongoDriver
{

    private static ManagedMongoDriver instance = new ManagedMongoDriver();

    public static ManagedMongoDriver getInstance()
    {
        return instance;
    }

    private Mongo mongo;

    private Mongo createMongo () {
        try {
            mongo = new Mongo("198.101.202.204", 27017);
        }
        catch (UnknownHostException e) {
            // NOP
        }
        return mongo;
    }

    private Mongo getMongoInstance () {
        if (null == mongo) {
            createMongo();
        }
        return mongo;
    }

    public DB getDB (String name) {
        DB db = getMongoInstance().getDB(name);

        return db;
    }

    public DBCollection getCollection (String databaseName, String collectionName) {
        DBCollection collection = getDB(databaseName).getCollection(collectionName);
        return collection;

    }

}
