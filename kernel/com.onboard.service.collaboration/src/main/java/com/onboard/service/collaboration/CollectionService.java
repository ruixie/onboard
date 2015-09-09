package com.onboard.service.collaboration;

import java.util.List;

import com.onboard.domain.model.Collection;

public interface CollectionService {

    public Collection getCollectionById(int id);

    public Collection createCollection(int userId, int attachId, String attachType);

    public List<Collection> getCollectionsByAttachTypeAndId(int userId, int attachId, String attachType);

    public List<Collection> getCollectionsByUserId(int userId);

    public void deleteCollection(int id);

}
