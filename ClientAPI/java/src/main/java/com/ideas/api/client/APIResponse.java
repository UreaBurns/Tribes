package com.ideas.api.client;

import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/**
 * API Response
 */
public class APIResponse
{

    private Long status;
    private String rawResponseString;
    private Object response;

    public Long getStatus()
    {
        return status;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    public String getRawResponseString()
    {
        return rawResponseString;
    }

    public void setRawResponseString(String rawResponseString)
    {
        this.rawResponseString = rawResponseString;
    }

    public Object getResponse()
    {
        return response;
    }

    public void setResponse(Object data)
    {
        this.response = data;
    }
}
