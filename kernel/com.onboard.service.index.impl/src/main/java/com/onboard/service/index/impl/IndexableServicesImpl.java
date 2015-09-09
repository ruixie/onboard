package com.onboard.service.index.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.type.Indexable;
import com.onboard.service.index.custom.IndexableService;
import com.onboard.service.index.custom.IndexableServices;

@Service("indexableServicesBean")
public class IndexableServicesImpl implements IndexableServices {
    
    private static final Map<String, IndexableService> indexableServices = Collections
            .synchronizedMap(new HashMap<String, IndexableService>());

    public synchronized void addIndexableService(IndexableService indexableService) {
        if (indexableService != null) {
            indexableServices.put(indexableService.modelType(), indexableService);
        }
    }

    public synchronized void removeIndexableService(IndexableService indexableService) {
        if (indexableService != null) {
            indexableServices.remove(indexableService.modelType());
        }
    }

    @Override
    public IndexableService getIndexableService(Indexable indexable) {
        if(indexable == null){
            return null;
        }
        return indexableServices.get(indexable.getType());
    }
    
    @Override
    public IndexableService getIndexableService(String modelType) {
        if(modelType == null){
            return null;
        }
        return indexableServices.get(modelType);
    }

}
