package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Collection;
import com.onboard.dto.CollectionDTO;

public class CollectionTransform {

    public static final Function<Collection, CollectionDTO> COLLECTION_DTO_FUNCTION = new Function<Collection, CollectionDTO>() {
        @Override
        public CollectionDTO apply(Collection input) {
            CollectionDTO result = collectionToCollectionDTO(input);
            return result;
        }
    };

    public static CollectionDTO collectionToCollectionDTO(Collection collection) {
        CollectionDTO collectionDTO = new CollectionDTO();
        BeanUtils.copyProperties(collection, collectionDTO);
        return collectionDTO;
    }

}
