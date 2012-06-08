package org.goodtech.tribes.members;

import org.goodtech.tribes.tribes.Role;

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
 * Created 6/2/12 8:37 AM
 */

/**
 * A roster is a grouping of individuals with a description of their roles
 * with in a organizational structure.
 */
public class Roster
{
    private Long id;
    private List<Member> memberList;
    private Map<Member, Role> rolesMap;

    /**
     * Get the ID of the roster.
     *
     * @return The ID of the roster.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set the ID of the roster.
     *
     * @param id The ID of the roster.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the list of members registered in the roster.
     *
     * @return A list of members registered in the roster.
     */
    public List<Member> getMemberList()
    {
        return memberList;
    }

    /**
     * Set the list of members registered in the roster.
     *
     * @param memberList The list of members registered in the roster.
     */
    public void setMemberList(List<Member> memberList)
    {
        this.memberList = memberList;
    }

    /**
     * Get a map of members and the roles they fulfill.
     *
     * @return A list of members and the roles the fulfill.
     */
    public Map<Member, Role> getRolesMap()
    {
        return rolesMap;
    }

    /**
     * Set the a map of members and the roles they fulfill.
     *
     * @param rolesMap A map of members and the roles they fulfill.
     */
    public void setRolesMap(Map<Member, Role> rolesMap)
    {
        this.rolesMap = rolesMap;
    }
}
