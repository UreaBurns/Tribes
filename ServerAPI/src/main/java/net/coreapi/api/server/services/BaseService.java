package net.coreapi.api.server.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Created 5/16/12 9:41 PM
 *
 * User Stories:
 * I would like to be able to describe an aggragate of data that I would like to consume regularrly.
 * I would like to be able to download the described aggragate at any time by giving you the
 * name of the aggragate so that I do not have to describe it in each request
 */
public abstract class BaseService
{
    @GET
    @Path("/")
    public APIResponse getMethods () {
        return getMethodsThroughReflection();
    }

    protected APIResponse createErrorResponse(int status, String messag) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(status);
        APIException apiException = new APIException();
        apiException.setErrorMessage(messag);
        apiResponse.setData(apiException);

        return apiResponse;
    }

    /**
     * Get all of the Path interfaces for class methods.
     *
     * @return The API methods available through this service.
     */
    private APIResponse getMethodsThroughReflection () {

        List<APIMethod> stringList = new ArrayList<APIMethod>();
        Method[] methods = this.getClass().getMethods();

        for (Method method : methods) {

            Annotation[] annotations = method.getDeclaredAnnotations();

            for(Annotation annotation : annotations){
                if(annotation instanceof Path){
                    Path myAnnotation = (Path) annotation;
                    APIMethod apiMethod = new APIMethod();
                    apiMethod.setSignature(myAnnotation.value());
                    apiMethod.setStatus("online");
                    apiMethod.setVersion("0.0.1");
                    stringList.add(apiMethod);
                }
            }
        }

        Map<String, Object> stringObjectMap = new HashMap<String, Object>();

        stringObjectMap.put("stats", "online");
        stringObjectMap.put("methods", stringList);
        APIResponse apiResponse = new APIResponse(stringObjectMap, 200);


        return apiResponse;
    }

    protected APIResponse createNewAPIResponse () {
        return new APIResponse();
    }
}
