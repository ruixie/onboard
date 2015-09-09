package com.onboard.test.exampleutils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public abstract class AbstractMatcher<T> implements Matcher<T> {

    public void describeMismatch(Object arg0, Description arg1) {
        // TODO:生成提示信息
    }

    @Override
    public void describeTo(Description arg0) {
    }

    @Override
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
    }

}
