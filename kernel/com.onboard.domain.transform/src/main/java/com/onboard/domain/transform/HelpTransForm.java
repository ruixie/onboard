package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.HelpTip;
import com.onboard.dto.HelpTipDTO;

public class HelpTransForm {

    public static final Function<HelpTip, HelpTipDTO> HELPTIP_DTO_FUNCTION = new Function<HelpTip, HelpTipDTO>() {
        @Override
        public HelpTipDTO apply(HelpTip input) {
            return helpToHelpDTO(input);
        }
    };

    public static HelpTipDTO helpToHelpDTO(HelpTip helpTip) {
        HelpTipDTO helpTipDTO = new HelpTipDTO();
        BeanUtils.copyProperties(helpTip, helpTipDTO);
        return helpTipDTO;
    }

}
