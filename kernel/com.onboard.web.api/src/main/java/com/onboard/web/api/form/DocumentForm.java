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
