package com.onboard.domain.transform;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Attachment;
import com.onboard.dto.AttachmentDTO;
import com.onboard.dto.TagDTO;

public class AttachmentTransform {

    public static final Function<Attachment, AttachmentDTO> ATTACHMENT_TO_ATTACHMENTDTO_FUNCTION = new Function<Attachment, AttachmentDTO>() {
        @Override
        public AttachmentDTO apply(Attachment input) {
            return attachmentToAttachmentDTO(input);
        }
    };
    public static final Function<AttachmentDTO, Attachment> ATTACHMENTDTO_TO_ATTACHMENT_FUNCTION = new Function<AttachmentDTO, Attachment>() {
        @Override
        public Attachment apply(AttachmentDTO input) {
            return attachmentDTOToAttachment(input);
        }
    };

    public static final AttachmentDTO attachmentToAttachmentDTO(Attachment attachment) {
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        BeanUtils.copyProperties(attachment, attachmentDTO);
        if (attachment.getTags() != null) {
            List<TagDTO> tagDtos = Lists.transform(attachment.getTags(), TagTransform.TAG_TO_TAGDTO_FUNCTION);
            attachmentDTO.setTagDtos(tagDtos);
        }
        return attachmentDTO;
    }

    public static final Attachment attachmentDTOToAttachment(AttachmentDTO attachmentDTO) {
        Attachment attachment = new Attachment();
        BeanUtils.copyProperties(attachmentDTO, attachment);
        if (attachmentDTO.getTagDtos() != null) {
            attachment.setTags(Lists.transform(attachmentDTO.getTagDtos(), TagTransform.TAGDTO_TO_TAG_FUNCTION));
        }
        return attachment;
    }

}
