package com.onboard.domain.model;

import com.onboard.domain.mapper.model.UserObject;
import com.onboard.domain.model.type.BaseOperateItem;
import com.onboard.domain.model.type.Typeable;

/**
 * 领域模型：User
 * 
 * @author ruici
 * 
 */
public class User extends UserObject implements Typeable, BaseOperateItem {

    private static final long serialVersionUID = 8649426265472715988L;

    public User() {
        super();
    }

    public User(int id) {
        super(id);
    }

    public User(User obj) {
        super(obj);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(User.class))) {
            return false;
        }
        User user = (User) obj;

        return this.getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() == null ? super.hashCode() : this.getId();
    }

    private Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getType() {
        return "user";
    }

    @Override
    public Boolean getDeleted() {
        return false;
    }

    @Override
    public void setDeleted(Boolean deleted) {
    }

    @Override
    public boolean trashRequried() {
        return true;
    }

}
