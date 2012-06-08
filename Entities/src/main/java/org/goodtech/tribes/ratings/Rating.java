package org.goodtech.tribes.ratings;

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
 * Created 6/2/12 8:40 AM
 */

/**
 * A ratting value.
 */
public class Rating
{
    private Long id;
    private float value;

    /**
     * Get the ID of the rating.
     *
     * @return The ID of the rating.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set the ID of the rating.
     *
     * @param id The ID of the rating.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the value of the rating. This value MUST be between 0. and 1.
     *
     * @return The value of the rating.
     * @TODO figure out how to enforce the limits needed by this entity.
     */
    public float getValue()
    {
        return value;
    }

    /**
     * Set the value of the rating.
     *
     * @param value The value of the rating.
     */
    public void setValue(float value)
    {
        this.value = value;
    }
}
