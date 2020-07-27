package com.njupt.o2o.dto;

public class Result<T> {
    /**
     * 是否成功标志
     */
    private boolean success;
    /**
     * 成功返回的数据
     */
    private T data ;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 错误码
     */
    private int errorCode;

    public Result() {
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, int errorCode,String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
