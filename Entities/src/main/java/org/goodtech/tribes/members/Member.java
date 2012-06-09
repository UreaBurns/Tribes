package org.goodtech.tribes.members;

import org.goodtech.tribes.location.GeoLocation;
import org.goodtech.tribes.tribes.Tribe;

import java.util.List;

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
 * Created 6/5/12 12:19 AM
 */

/**
 * A member is an external entity (a person, business, a sensor, a device, etc) that acts as a member of a tribe.
 */
public class Member
{
    private Long id;
    private List<Tribe> tribeList;

    private String name;
    private Persona persona;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Tribe> getTribeList()
    {
        return tribeList;
    }

    public void setTribeList(List<Tribe> tribeList)
    {
        this.tribeList = tribeList;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Persona getPersona()
    {
        return persona;
    }

    public void setPersona(Persona persona)
    {
        this.persona = persona;
    }
}
