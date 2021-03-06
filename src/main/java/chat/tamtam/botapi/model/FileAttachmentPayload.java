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
 * FileAttachmentPayload
 */
public class FileAttachmentPayload extends AttachmentPayload implements TamTamSerializable {

    private final Long fileId;

    @JsonCreator
    public FileAttachmentPayload(@JsonProperty("fileId") Long fileId, @JsonProperty("url") String url) { 
        super(url);
        this.fileId = fileId;
    }

    /**
    * Identifier of uploaded file
    * @return fileId
    **/
    @JsonProperty("fileId")
    public Long getFileId() {
        return fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        FileAttachmentPayload other = (FileAttachmentPayload) o;
        return Objects.equals(this.fileId, other.fileId) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileAttachmentPayload{"+ super.toString()
            + " fileId='" + fileId + '\''
            + '}';
    }
}
