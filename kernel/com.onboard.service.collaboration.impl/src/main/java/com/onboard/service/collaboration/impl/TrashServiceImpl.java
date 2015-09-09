package com.onboard.service.collaboration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.TrashMapper;
import com.onboard.domain.mapper.model.TrashExample;
import com.onboard.domain.model.Trash;
import com.onboard.service.collaboration.TrashService;
import com.onboard.service.common.identifiable.IdentifiableManager;

/**
 * {@link com.onboard.service.collaboration.TrashService} Service implementation
 * 
 * @generated_by_elevenframework
 * 
 */
@Transactional
@Service("trashServiceBean")
public class TrashServiceImpl implements TrashService {

    @Autowired
    private TrashMapper trashMapper;

    @Autowired
    private IdentifiableManager identifiableManager;

    @Override
    public Trash getTrashById(int id) {
        Trash trash = trashMapper.selectByPrimaryKey(id);
        trash.setIdentifiable(identifiableManager.getIdentifiableByTypeAndId(trash.getAttachType(), trash.getAttachId()));
        return trash;
    }

    @Override
    public List<Trash> getTrashes(int start, int limit) {
        TrashExample example = new TrashExample(new Trash());
        example.setLimit(start, limit);
        return trashMapper.selectByExample(example);
    }

    @Override
    public List<Trash> getTrashesByExample(Trash item, int start, int limit) {
        TrashExample example = new TrashExample(item);
        example.setLimit(start, limit);
        return trashMapper.selectByExample(example);
    }

    @Override
    public int countByExample(Trash item) {
        TrashExample example = new TrashExample(item);
        return trashMapper.countByExample(example);
    }

    @Override
    public Trash addTrash(Trash item) {
        trashMapper.insert(item);
        return item;
    }

    @Override
    public Trash updateTrash(Trash item) {
        trashMapper.updateByPrimaryKey(item);
        return item;
    }

    @Override
    public void deleteTrash(int id) {
        trashMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteTrashByExample(Trash trash) {
        trashMapper.deleteByExample(new TrashExample(trash));
    }

}
