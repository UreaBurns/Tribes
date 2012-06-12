package com.geoapi.server;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.scottbyrns.utilities.JSONObjectMapper;
import net.coreapi.mongo.documents.ManagedMongoDriver;
import org.junit.Test;

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
 * Created 6/12/12 1:23 AM
 */
public class TestManagedMongoDriver
{
    @Test
    public void testGetCollection () {
        ManagedMongoDriver managedMongoDriver = new ManagedMongoDriver();
        DBCollection dbCollection = managedMongoDriver.getCollection("TestDatabase",
                                                      "TestCollection");
        DBObject dbObject = (DBObject) JSON.parse("{\"test\":1}");
        dbCollection.insert(dbObject);

        assertTrue(dbCollection.find().next().equals(dbObject));
    }


}
