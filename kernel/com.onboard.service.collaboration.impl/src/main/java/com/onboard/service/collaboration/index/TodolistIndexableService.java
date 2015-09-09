package com.onboard.service.collaboration.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.domain.mapper.TodolistMapper;
import com.onboard.domain.mapper.model.TodolistExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Todolist;
import com.onboard.domain.model.type.Indexable;
import com.onboard.service.index.custom.IndexableService;
import com.onboard.service.index.model.IndexDocument;
import com.onboard.service.index.model.IndexDocumentBuilder;

/**
 * 针对{@link Todolist}实现的{@link IndexableService}
 * 
 * @author yewei
 *
 */
@Service("todolistIndexableServiceBean")
public class TodolistIndexableService implements IndexableService {

    @Autowired
    private TodolistMapper todolistMapper;

    @Override
    public String modelType() {
        return new Todolist().getType();
    }

    @Override
    public List<Indexable> getIndexablesByExample(BaseExample baseExample) {
        List<Indexable> items = new ArrayList<Indexable>();
        List<Todolist> todolists = todolistMapper.selectByExample((TodolistExample) baseExample);
        items.addAll(todolists);
        return items;
    }

    @Override
    public IndexDocument indexableToIndexDocument(Indexable indexable) {
        Todolist todolist = todolistMapper.selectByPrimaryKey(indexable.getId());
        List<Integer> relators = Lists.newArrayList(todolist.getCreatorId());
        return IndexDocumentBuilder.getBuilder()
                .indexable(todolist)
                .title(todolist.getName())
                .relatorIds(relators)
                .build();
    }

}
