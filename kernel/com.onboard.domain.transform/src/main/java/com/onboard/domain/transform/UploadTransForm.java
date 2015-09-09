package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Upload;
import com.onboard.dto.UploadDTO;

public class UploadTransForm {

    public static final Function<Upload, UploadDTO> HELPTIP_DTO_FUNCTION = new Function<Upload, UploadDTO>() {
        @Override
        public UploadDTO apply(Upload input) {
            return uploadToUploadDTO(input);
        }
    };

    public static UploadDTO uploadToUploadDTO(Upload upload) {
        UploadDTO uploadDTO = new UploadDTO();
        BeanUtils.copyProperties(upload, uploadDTO);
        return uploadDTO;
    }

}
