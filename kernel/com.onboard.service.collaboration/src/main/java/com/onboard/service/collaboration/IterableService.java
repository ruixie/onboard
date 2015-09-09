package com.onboard.service.collaboration;

import com.onboard.domain.model.type.Iterable;

public interface IterableService<I extends Iterable> {

    I getIterableWithBoardables(Integer id);

    I getIterable(Integer id);

}
