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

import org.goodtech.tribes.members.Member;

/**
 * A message is a set of information that is passed from one entity (the creator/ sender)
 * to a target entity (consumer / receiver).
 */
public class Message extends Document
{
    private Member source;
    private Member destination;

    public Member getSource()
    {
        return source;
    }

    public void setSource(Member source)
    {
        this.source = source;
    }

    public Member getDestination()
    {
        return destination;
    }

    public void setDestination(Member destination)
    {
        this.destination = destination;
    }
}
