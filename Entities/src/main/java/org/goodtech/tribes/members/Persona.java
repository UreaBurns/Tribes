package org.goodtech.tribes.members;

import java.util.List;
import java.util.Map;

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
 * Created 6/5/12 12:26 AM
 */

/**
 * A persona is a description of the attributes that compose an entities
 * personification of its self.
 */
public class Persona
{
    private Long id;
    private List<Attribute> attributeList;

    /**
     * Get the ID of the persona.
     *
     * @return The ID of the persona.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set the ID of the persona.
     *
     * @param id The ID of the persona.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the list of attributes personified by this persona.
     *
     * @return The list of attributes personified by this persona.
     */
    public List<Attribute> getAttributeList()
    {
        return attributeList;
    }

    /**
     * Set the list of attributes personified by this persona.
     *
     * @param attributeList The list of attributes personified by this persona.
     */
    public void setAttributeList(List<Attribute> attributeList)
    {
        this.attributeList = attributeList;
    }
}
