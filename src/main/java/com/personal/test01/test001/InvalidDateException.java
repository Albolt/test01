package com.personal.test01.test001;

/**
 * @Creater albolt
 * @12/12/20 7:48 PM
 */

public class InvalidDateException extends RuntimeException {
    private static final long serialVersionUID = -1044194877928296024L;
    private String message;
    private Object data;

    public InvalidDateException(Exception e) {
        super(e);
    }

    public InvalidDateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
