package com.onboard.service.email.impl;

import com.onboard.service.email.TemplateEngineService;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring3.SpringTemplateEngine;

import java.util.Locale;
import java.util.Map;

public class OSGiTemplateEngine extends SpringTemplateEngine implements TemplateEngineService {

    @Override
    public String process(Class<?> clazz, String templateName, Map<String, ?> model) {
        final Context ctx = new Context(Locale.getDefault(), model);
        ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(clazz.getClassLoader());
            return super.process(templateName, ctx);
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassLoader);
        }
    }
}
