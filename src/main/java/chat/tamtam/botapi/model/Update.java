/*
 * ------------------------------------------------------------------------
 * TamTam chat Bot API
 * ------------------------------------------------------------------------
 * Copyright (C) 2018 Mail.Ru Group
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ------------------------------------------------------------------------
 */

package chat.tamtam.botapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;


/**
 * &#x60;Update&#x60; object repsesents different types of events that happened in chat. See its inheritors
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "update_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = MessageCreatedUpdate.class, name = "message_created"),
  @JsonSubTypes.Type(value = MessageCallbackUpdate.class, name = "message_callback"),
  @JsonSubTypes.Type(value = MessageEditedUpdate.class, name = "message_edited"),
  @JsonSubTypes.Type(value = MessageRemovedUpdate.class, name = "message_removed"),
  @JsonSubTypes.Type(value = MessageRestoredUpdate.class, name = "message_restored"),
  @JsonSubTypes.Type(value = BotAddedToChatUpdate.class, name = "bot_added"),
  @JsonSubTypes.Type(value = BotRemovedFromChatUpdate.class, name = "bot_removed"),
  @JsonSubTypes.Type(value = UserAddedToChatUpdate.class, name = "user_added"),
  @JsonSubTypes.Type(value = UserRemovedFromChatUpdate.class, name = "user_removed"),
})
public class Update implements TamTamSerializable {

    private String updateType;
    private final Long timestamp;

    @JsonCreator
    public Update(@JsonProperty("timestamp") Long timestamp) { 
        this.timestamp = timestamp;
    }

    /**
    * @return updateType
    **/
    @JsonProperty("update_type")
    public String getUpdateType() {
        return updateType;
    }

    /**
    * Unix-time when event occured
    * @return timestamp
    **/
    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        Update other = (Update) o;
        return Objects.equals(this.updateType, other.updateType) &&
            Objects.equals(this.timestamp, other.timestamp);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (updateType != null ? updateType.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Update{"
            + " updateType='" + updateType + '\''
            + " timestamp='" + timestamp + '\''
            + '}';
    }
}
