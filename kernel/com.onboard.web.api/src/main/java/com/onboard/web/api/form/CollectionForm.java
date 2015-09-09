package com.onboard.web.api.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.onboard.domain.model.Collection;

public class CollectionForm extends Collection {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String attachType;

    @Min(1)
    private Integer attachId;

    @Override
    public String getAttachType() {
        return attachType;
    }

    @Override
    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    @Override
    public Integer getAttachId() {
        return attachId;
    }

    @Override
    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }
}
