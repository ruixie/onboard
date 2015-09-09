package com.onboard.domain.model;

import com.onboard.domain.mapper.model.HelpTipObject;
import com.onboard.domain.model.type.BaseOperateItem;

/**
 * Domain model: HelpTip
 * 
 * @generated_by_elevenframework
 * 
 */
public class HelpTip extends HelpTipObject implements BaseOperateItem {

    private static final long serialVersionUID = -7098298341718777547L;

    public HelpTip() {
        super();
    }

    public HelpTip(int id) {
        super(id);
    }

    public HelpTip(HelpTipObject obj) {
        super(obj);
    }

    @Override
    public String getType() {
        return "help-tip";
    }

    @Override
    public boolean trashRequried() {
        return false;
    }

}
