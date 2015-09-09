package com.onboard.service.email;

import java.util.concurrent.Future;


public interface EmailService {

    /**
     * 简单的邮件发送服务
     * @author Gou Rui 
     * @param to 收件人邮件地址
     * @param cc 抄送邮件地址
     * @param bcc 密送邮件地址
     * @param subject 主题
     * @param 邮件正文，由于设置的contentType是text/html，所以content可以是html格式的
     */
    Future<Boolean> sendEmail(String to, String[] cc, String[] bcc, String subject,
                              String content, String replyTo);

    /**
     * 简单的邮件发送服务
     * @author Gou Rui 
     * @param to 收件人邮件地址
     * @param cc 抄送邮件地址
     * @param bcc 密送邮件地址
     * @param subject 主题
     * @param 邮件正文，由于设置的contentType是text/html，所以content可以是html格式的
     */
    Future<Boolean> sendEmail(String from, String to, String[] cc, String[] bcc, String subject,
                              String content, String replyTo);
}
