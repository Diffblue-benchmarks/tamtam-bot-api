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
import java.util.Objects;


/**
 * ActionRequestBody
 */
public class ActionRequestBody implements TamTamSerializable {

    private final SenderAction action;

    @JsonCreator
    public ActionRequestBody(@JsonProperty("action") SenderAction action) { 
        this.action = action;
    }

    /**
    * @return action
    **/
    @JsonProperty("action")
    public SenderAction getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        ActionRequestBody other = (ActionRequestBody) o;
        return Objects.equals(this.action, other.action);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionRequestBody{"
            + " action='" + action + '\''
            + '}';
    }
}
