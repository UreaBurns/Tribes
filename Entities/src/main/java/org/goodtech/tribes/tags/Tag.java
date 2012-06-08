package org.goodtech.tribes.tags;

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
 * Created 6/2/12 8:38 AM
 */

/**
 * A tag that describes generically an attribute of a tagged item.
 */
public class Tag
{
    private Long id;
    private String label;

    /**
     * Get the ID of the tag.
     *
     * @return The ID of the tag.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set the ID of the tag.
     *
     * @param id The ID of the tag.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the label of the tag, this is the verbose name of the tag.
     *
     * @return The label of the tag.
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Set the label of the tag, this is the verbose name of the tag.
     *
     * @param label The label of the tag.
     */
    public void setLabel(String label)
    {
        this.label = label;
    }
}
