package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Tag;
import com.onboard.dto.TagDTO;

public class TagTransform {

    public static final Function<Tag, TagDTO> TAG_TO_TAGDTO_FUNCTION = new Function<Tag, TagDTO>() {
        @Override
        public TagDTO apply(Tag input) {
            return tagToTagDTO(input);
        }
    };
    public static final Function<TagDTO, Tag> TAGDTO_TO_TAG_FUNCTION = new Function<TagDTO, Tag>() {
        @Override
        public Tag apply(TagDTO input) {
            return tagDTOtoTag(input);
        }
    };

    public static TagDTO tagToTagDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        BeanUtils.copyProperties(tag, tagDTO);
        return tagDTO;
    }

    public static Tag tagDTOtoTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDTO, tag);
        return tag;
    }

}
