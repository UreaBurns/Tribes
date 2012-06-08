package org.goodtech.tribes.tribes;

import org.goodtech.tribes.ratings.Rateable;
import org.goodtech.tribes.ratings.Rating;
import org.goodtech.tribes.members.Roster;
import org.goodtech.tribes.messages.Message;
import org.goodtech.tribes.messages.Messageable;

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
 * Created 6/2/12 8:36 AM
 */

/**
 * A tribe is a grouping of a roster and a subject that can act as an individual entity.
 */
public class Tribe
{
    private String name;
    private String description;
    private Subject subjectOfFocus;
    private Roster memberRoster;

    /**
     * Get the name of the tribe.
     *
     * @return The name of the tribe.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the tribe.
     *
     * @param name The name of the tribe.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the description of the tribe.
     *
     * @return The description of the tribe.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set the description of the tribe.
     *
     * @param description The description of the tribe.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the subject of focus for the tribe.
     *
     * @return The subject of focus for the tribe.
     */
    public Subject getSubjectOfFocus()
    {
        return subjectOfFocus;
    }

    /**
     * Set the subject of focus for the tribe.
     *
     * @param subjectOfFocus The subject of focus for the tribe.
     */
    public void setSubjectOfFocus(Subject subjectOfFocus)
    {
        this.subjectOfFocus = subjectOfFocus;
    }

    /**
     * Get the roster of members in the tribe.
     *
     * @return The roster of members in the tribe.
     */
    public Roster getMemberRoster()
    {
        return memberRoster;
    }

    /**
     * Set the member forster for the tribe.
     *
     * @param memberRoster The member roster for the tribe.
     */
    public void setMemberRoster(Roster memberRoster)
    {
        this.memberRoster = memberRoster;
    }

}
