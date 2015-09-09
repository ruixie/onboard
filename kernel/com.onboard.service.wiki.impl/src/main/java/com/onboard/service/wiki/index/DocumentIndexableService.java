package com.onboard.service.wiki.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.domain.mapper.DocumentMapper;
import com.onboard.domain.mapper.model.DocumentExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.type.Indexable;
import com.onboard.service.index.custom.IndexableService;
import com.onboard.service.index.model.IndexDocument;
import com.onboard.service.index.model.IndexDocumentBuilder;

/**
 * 针对{@link Document}实现的{@link IndexableService}
 * 
 * @author yewei
 * 
 */
@Service("documentIndexableServiceBean")
public class DocumentIndexableService implements IndexableService {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public String modelType() {
        return new Document().getType();
    }

    @Override
    public List<Indexable> getIndexablesByExample(BaseExample baseExample) {
        List<Indexable> items = new ArrayList<Indexable>();
        List<Document> documents = documentMapper.selectByExample((DocumentExample) baseExample);
        items.addAll(documents);
        return items;
    }

    @Override
    public IndexDocument indexableToIndexDocument(Indexable indexable) {
        Document document = documentMapper.selectByPrimaryKey(indexable.getId());
        List<Integer> relators = Lists.newArrayList(document.getCreatorId());
        return IndexDocumentBuilder
                .getBuilder()
                .indexable(document)
                .content(document.getContent())
                .title(document.getTitle())
                .relatorIds(relators)
                .build();
    }

}
