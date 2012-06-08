package net.coreapi.dao;

import net.coreapi.api.data.source.Redis;
import redis.clients.jedis.Jedis;

/**
 * Copyright (C) 2012 by Michael Scott Byrns & Carmelo Uria
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
 * Created 5/17/12 3:36 PM
 */
public class LocationDAO
{
    public String create (Long latitude, Long longitude)
    {
        String locationJSON = "";

        if (Redis.isConnected()) {
            long uid = Redis.incr("latest-location-id");
            locationJSON = "{\"id\": \"" + uid + "\", \"latitude\": \"" + latitude + "\", \"longitude\", \"" + longitude + "\"}";
//            jedis.rpush("locations", "" + uid);
            Redis.set("location-with-id-" + uid, locationJSON);
        }
        else {

        }
        return locationJSON;
    }

    public String get ()
    {
        if (Redis.isConnected()) {
            Jedis jedis = new Jedis("localhost");
            jedis.isConnected();
            jedis.connect();
            System.out.println(jedis.get("latest-location-id"));
            System.out.println(jedis.get("location-with-id-" + jedis.get("latest-location-id")));
            return jedis.get("location-with-id-" + jedis.get("latest-location-id"));
        }
        else {

        }
        return "";
    }

    public String getLocationById (Long id)
    {
        if (Redis.isConnected()) {
            return Redis.get("location-with-id-" + id);
        }
        return "";
    }
}
