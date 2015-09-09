package com.onboard.domain.model.type;

public interface BaseCompanyItem extends BaseOperateItem {

    Integer getCompanyId();

    void setCompanyId(Integer companyId);

    // String getCompanyName();
    // void setCompanyName(String companyName);

    Integer getCreatorId();

    void setCreatorId(Integer creatorId);

    String getCreatorName();

    void setCreatorName(String creatorName);

    String getCreatorAvatar();

    void setCreatorAvatar(String creatorAvatar);
}
