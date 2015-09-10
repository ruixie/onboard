/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.web.api.form;

import org.hibernate.validator.constraints.Length;

import com.onboard.dto.DocumentDTO;

public class DocumentForm extends DocumentDTO {

    private String note;

    @Length(min = 1, max = 100, message = "标题长度必须在1-100之间")
    private String title;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        this.title = title;
    }

    public DocumentForm() {
        super();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
