package com.ntg.organization.organization.exception;

public enum Errors {
    EMPLOYEE_NOT_FOUND("0001","Employee doesn't exist"),
    DEPARTMENT_NOT_FOUND("0010","Department doesn't exist");

    private final String code;
    private final String message;

    private Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
