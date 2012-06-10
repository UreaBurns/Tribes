package com.ideas.api.client;

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
 * Created 6/9/12 4:31 PM
 */
public class APIResponseWrapper<Type>
{
    private double status;
    private Type response;

    public double getStatus()
    {
        return status;
    }

    public void setStatus(double status)
    {
        this.status = status;
    }

    public Type getResponse()
    {
        return response;
    }

    public void setResponse(Type response)
    {
        this.response = response;
    }
}
