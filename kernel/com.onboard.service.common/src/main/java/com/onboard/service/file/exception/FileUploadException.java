package com.onboard.service.file.exception;

/**
 * 文件上传异常类
 * 
 * @author yewei
 * 
 */
@SuppressWarnings("serial")
public class FileUploadException extends RuntimeException {
    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
