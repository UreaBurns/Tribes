package org.goodtech.tribes.messages;

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
 * Created 6/2/12 8:41 AM
 */

import java.util.Map;

/**
 * A message is a set of information that is passed from one entity (the creator/ sender)
 * to a target entity (consumer / receiver).
 */
public class Message
{
    private Long id;
    private Long audienceId;
    private Long authorId;
    private MessageType messageType;
    private Map<String, Object> messageDataMap;

    /**
     * Get the ID of the message.
     *
     * @return The ID of the message.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Set the ID of the message.
     *
     * @param id The ID of the message.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Get the ID of the messages intended audience.
     *
     * @return The ID of the messages intended audience.
     */
    public Long getAudienceId()
    {
        return audienceId;
    }

    /**
     * Set the ID of the intended audience.
     *
     * @param audienceId The ID of the intended audience.
     */
    public void setAudienceId(Long audienceId)
    {
        this.audienceId = audienceId;
    }

    /**
     * Get the ID of the messaged author.
     *
     * @return The ID of the messages author.
     */
    public Long getAuthorId()
    {
        return authorId;
    }

    /**
     * Set the ID of the author.
     *
     * @param authorId The ID of the author.
     */
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    /**
     * Get the messages type. This is used to know what type of message reader will
     * be needed to parse a messages data.
     *
     * @return The messages type.
     */
    public MessageType getMessageType()
    {
        return messageType;
    }

    /**
     * Set the messages type. This is used to know what type of message reader will
     * be needed to parse a messages data.
     *
     * @param messageType The messages type.
     */
    public void setMessageType(MessageType messageType)
    {
        this.messageType = messageType;
    }

    /**
     * Get a map of all of the data in the message.
     *
     * @return A map of the messages data.
     */
    public Map<String, Object> getMessageDataMap()
    {
        return messageDataMap;
    }

    /**
     * Set a map containing the messages data.
     *
     * @param messageDataMap A map of the messages data.
     */
    public void setMessageDataMap(Map<String, Object> messageDataMap)
    {
        this.messageDataMap = messageDataMap;
    }
}
