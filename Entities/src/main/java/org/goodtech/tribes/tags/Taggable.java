package org.goodtech.tribes.tags;

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
 * Created 6/5/12 12:02 PM
 */
public interface Taggable
{
    /**
     * Add a tag to a taggable object.
     *
     * @param tag The tag to apply to a taggable object.
     */
    public void addTag(Tag tag);

    /**
     * Get the list of tags on the taggable object.
     *
     * @return The list of tags on the taggable object.
     */
    public List<Tag> getTagList();

    /**
     * Remove a tag from a taggable object.
     *
     * @param tag The tag to remove from the taggable object.
     * @return Boolean representaion of whether or not the tag was removed.
     * This should be false if the tag was not present.
     */
    public boolean removeTag(Tag tag);
}
