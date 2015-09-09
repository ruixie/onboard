package com.onboard.service.security.exception;

public class NoPermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer companyId;

    public NoPermissionException() {

    }

    public NoPermissionException(Integer companyId) {
        super();
        this.setCompanyId(companyId);
    }

    public NoPermissionException(Integer companyId, String message) {
        super(message);
        this.setCompanyId(companyId);
    }

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(String message) {
        super(message);
    }

    public NoPermissionException(Throwable cause) {
        super(cause);
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

}
