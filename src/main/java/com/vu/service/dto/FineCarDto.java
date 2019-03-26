package com.vu.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vu.service.base.BaseResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FineCarDto extends BaseResponse {

    private String plateNumber;
    private String totalAmount;
    private List<TrafficDetailsDto> trafficDetailsDtos;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TrafficDetailsDto> getTrafficDetailsDtos() {
        return trafficDetailsDtos;
    }

    public void setTrafficDetailsDtos(List<TrafficDetailsDto> trafficDetailsDtos) {
        this.trafficDetailsDtos = trafficDetailsDtos;
    }
}
