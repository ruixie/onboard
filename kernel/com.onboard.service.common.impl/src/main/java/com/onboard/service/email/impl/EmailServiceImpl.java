package com.onboard.service.email.impl;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.service.email.EmailService;
import com.onboard.service.email.InternalEmailService;

@Service("emailServiceBean")
public class EmailServiceImpl implements EmailService {

    public static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    
    private final List<InternalEmailService> emailServices = Lists.newArrayList();
    private final EmptyEmailServiceImpl emptyEmailService = new EmptyEmailServiceImpl();
    
    public synchronized void addInternalEmailService(InternalEmailService internalEmailService) {
        if (internalEmailService != null && !emailServices.contains(internalEmailService)) {
            emailServices.add(internalEmailService);
        }
    }

    public synchronized void removeInternalEmailService(InternalEmailService internalEmailService) {
        if (internalEmailService != null && emailServices.contains(internalEmailService)) {
            emailServices.remove(internalEmailService);
        }
    }
    
    private InternalEmailService getInternalEmailService(){
        if(emailServices.isEmpty()){
            return emptyEmailService;
        }
        //TODO: get email service by rule, not only the first one
        return emailServices.get(0);
    }

    @Override
    public Future<Boolean> sendEmail(String to, String[] cc, String[] bcc, String subject, String content, String replyTo) {
        return getInternalEmailService().sendEmail(to, cc, bcc, subject, content, replyTo);
    }

    @Override
    public Future<Boolean> sendEmail(String from, String to, String[] cc, String[] bcc, String subject, String content,
            String replyTo) {
        return getInternalEmailService().sendEmail(from, to, cc, bcc, subject, content, replyTo);
    }
}
