package com.vu.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vu.service.base.BaseResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointLicenseDto extends BaseResponse {

    private String finesCount;
    private String point;

    public String getFinesCount() {
        return finesCount;
    }

    public void setFinesCount(String finesCount) {
        this.finesCount = finesCount;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
