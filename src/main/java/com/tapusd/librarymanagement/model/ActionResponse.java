package com.tapusd.librarymanagement.model;

public class ActionResponse {
    private Boolean result;
    private String message;

    public ActionResponse result(Boolean result) {
        this.result = result;
        return this;
    }

    public ActionResponse message(String message) {
        this.message = message;
        return this;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ActionResponse successActionResponse() {
        return new ActionResponse().result(true).message("Success!");
    }

    public static ActionResponse successActionResponse(String message) {
        return new ActionResponse().result(true).message(message);
    }

    public static ActionResponse errorActionResponse() {
        return new ActionResponse().result(false).message("Error Occurred!");
    }

    public static ActionResponse errorActionResponse(String message) {
        return new ActionResponse().result(false).message(message);
    }
}
