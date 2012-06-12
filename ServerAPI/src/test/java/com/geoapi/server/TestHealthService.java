package com.geoapi.server;

import com.scottbyrns.utilities.JSONObjectMapper;
import net.coreapi.api.server.services.APIResponse;
import net.coreapi.api.server.services.HealthService;
import net.coreapi.api.server.services.ServerStatus;
import org.junit.Test;

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
 * Created 6/12/12 1:27 AM
 */
public class TestHealthService
{
    @Test
    public void testGetStatus () {
        HealthService healthService = new HealthService();
        APIResponse apiResponse = healthService.getStatus();

        try {
            ServerStatus serverStatus = (ServerStatus) JSONObjectMapper.mapJSONStringToEntity(apiResponse.getData().toString(), ServerStatus.class);
            assertEquals(serverStatus.getName(), new ServerStatus().getName());
        }
        catch (Throwable e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
