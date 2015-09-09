package com.onboard.service.common.attach;

import java.util.List;

import com.onboard.domain.model.type.BaseProjectItem;

public abstract class AbstractAttachService implements IdentifiableAttachService {

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(String attachType, int attachId) {
        return getIdentifiablesByAttachId(attachId);
    }

}
