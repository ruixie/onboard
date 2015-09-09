package com.onboard.service.email.impl;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.onboard.service.email.InternalEmailService;

@Service("emptyEmailServiceBean")
public class EmptyEmailServiceImpl implements InternalEmailService {

    public static final Logger logger = LoggerFactory.getLogger(EmptyEmailServiceImpl.class);

    @Override
    public Future<Boolean> sendEmail(String to, String[] cc, String[] bcc, String subject, String content, String replyTo) {
        logger.debug("mock email service");
        return new AsyncResult<Boolean>(true);
    }

    @Override
    public Future<Boolean> sendEmail(String from, String to, String[] cc, String[] bcc, String subject, String content,
            String replyTo) {
        logger.debug("mock email service");
        return new AsyncResult<Boolean>(true);
    }
}
