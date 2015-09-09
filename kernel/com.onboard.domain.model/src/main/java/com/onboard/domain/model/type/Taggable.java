package com.onboard.domain.model.type;

import java.util.List;

import com.onboard.domain.model.Tag;

public interface Taggable extends BaseProjectItem {

    List<Tag> getTags();
    
    void setTags(List<Tag> tags);
}
