package com.onboard.test.exampleutils;

import com.onboard.domain.mapper.model.common.BaseExample;

/**
 * Example Matcher for {@link BaseExample}
 * 
 * @author yewei
 * 
 */
public abstract class ExampleMatcher<T> extends AbstractMatcher<T> {

    @Override
    public boolean matches(Object arg0) {
        return matches((BaseExample) arg0);
    }

    public abstract boolean matches(BaseExample example);
}
