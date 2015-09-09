package com.onboard.service.index.custom;

import com.onboard.domain.model.type.Indexable;

public interface IndexableServices {
    
    IndexableService getIndexableService(Indexable indexable);
    
    IndexableService getIndexableService(String modelType);

}
