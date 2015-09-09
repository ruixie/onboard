package com.onboard.test.exampleutils;

import com.onboard.domain.mapper.model.common.BaseExample;

/**
 * Example Matcher for {@link BaseExample}
 * 
 * @author Dongdong Du
 * 
 */
public abstract class ObjectMatcher<T> extends AbstractMatcher<T> {

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(Object arg0) {
        return verifymatches((T) arg0);
    }

    public abstract boolean verifymatches(T item);
}
