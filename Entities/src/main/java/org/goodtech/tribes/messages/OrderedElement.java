package org.goodtech.tribes.messages;


import org.goodtech.statistics.NormalizedValue;

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
 * Created 6/11/12 12:54 PM
 */
public class OrderedElement
{
    private long id;
    private DocumentType elementType;
    private NormalizedValue normalizedValue;
    private Raw raw;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public DocumentType getElementType()
    {
        return elementType;
    }

    public void setElementType(DocumentType elementType)
    {
        this.elementType = elementType;
    }

    public NormalizedValue getNormalizedValue()
    {
        return normalizedValue;
    }

    public void setNormalizedValue(NormalizedValue normalizedValue)
    {
        this.normalizedValue = normalizedValue;
    }

    public Raw getRaw()
    {
        return raw;
    }

    public void setRaw(Raw raw)
    {
        this.raw = raw;
    }
}
