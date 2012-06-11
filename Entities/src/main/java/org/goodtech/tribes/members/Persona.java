package org.goodtech.tribes.members;

import org.goodtech.statistics.NormalizedValue;
import org.goodtech.tribes.tags.Tag;

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

    /**
     * This application will use normalized values for the tags.
     * Ultimately these normalized values will be driven by analysis
     * of historic values from a data warehouse.
     */
    private List<Personification> personificationList;


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

    public List<Personification> getPersonificationList()
    {
        return personificationList;
    }

    public void setPersonificationList(List<Personification> personificationList)
    {
        this.personificationList = personificationList;
    }
}
