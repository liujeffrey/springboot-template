package com.example.template.response;

/**
 * 响应元数据
 */
public class Meta {
    private boolean success;

    private String message;

    public Meta(boolean success) {
        this.success = success;
    }

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String str = "[success: %b, message: %s]";
        return String.format(str, success, message);
    }
}
