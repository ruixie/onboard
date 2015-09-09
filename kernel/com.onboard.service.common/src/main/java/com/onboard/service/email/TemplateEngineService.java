package com.onboard.service.email;

import java.util.Map;

/**
 * TemplateEngineService for Email.
 *
 * @author luoruici
 */
public interface TemplateEngineService {

    public String process(Class<?> clazz, String templateName, Map<String, ?> model);

}
