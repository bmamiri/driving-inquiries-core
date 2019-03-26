package com.vu.service.base;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class BaseResponse {

    private Integer httpCode;
    private String httpMsg;
    private Integer ApiCode;
    private String ApiMessage;

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMsg() {
        return httpMsg;
    }

    public void setHttpMsg(String httpMsg) {
        this.httpMsg = httpMsg;
    }

    @JsonAlias("code")
    public Integer getApiCode() {
        return ApiCode;
    }

    @JsonAlias("code")
    public void setApiCode(int apiCode) {
        ApiCode = apiCode;
    }

    @JsonAlias("message")
    public String getApiMessage() {
        return ApiMessage;
    }

    @JsonAlias("message")
    public void setApiMessage(String apiMessage) {
        ApiMessage = apiMessage;
    }
}
