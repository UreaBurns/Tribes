package org.goodtech.tribes.tribes;

import org.goodtech.tribes.tags.Tag;

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
 * Created 6/2/12 8:37 AM
 */

/**
 * The subject of focus that a tribe is built around.
 */
public class Subject
{
    /**
     * A list of tags that describe the subjects scope.
     */
    private List<Tag> tagList;

    /**
     * Get the tag list for the subject.
     * The tags describe the scope of the subject.
     *
     * @return Tag list.
     */
    public List<Tag> getTagList()
    {
        return tagList;
    }

    /**
     * Set the tag list for the subject.
     * The tags describe the scope of the subject.
     *
     * @param tagList The list of tags that describe the scope of the subject.
     */
    public void setTagList(List<Tag> tagList)
    {
        this.tagList = tagList;
    }
}
