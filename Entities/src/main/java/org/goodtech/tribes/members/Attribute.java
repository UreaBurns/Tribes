package org.goodtech.tribes.members;

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
 * Created 6/5/12 12:06 PM
 */

/**
 * An attribute is a single asdfasdfasdf
 * @param <AttributeValueType> The type of the attribute value.
 */
public class Attribute<AttributeValueType>
{
    private Long id;
    private String attributeName;
    private AttributeValueType value;

    /**
     * Get the ID of the attribute.
     *
     * @return The ID of the attribute.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set ID of the attribute.
     *
     * @param id The ID of the attribute.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the name of the attribute.
     *
     * @return The name of the attribute.
     */
    public String getAttributeName()
    {
        return attributeName;
    }

    /**
     * Set the name of the attribute.
     *
     * @param attributeName The name of the attribute.
     */
    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    /**
     * Get the value of the attribute.
     *
     * @return The value of the attribute.
     */
    public AttributeValueType getValue()
    {
        return value;
    }

    /**
     * Set the value of the attribute.
     *
     * @param value The value of the attribute.
     */
    public void setValue(AttributeValueType value)
    {
        this.value = value;
    }
}
