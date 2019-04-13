package com.vu.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vu.service.dto.FineCarDto;
import com.vu.service.dto.PointLicenseDto;
import com.vu.utils.ServiceUtil;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Optional;

@Service
public class DrivingInquiryService {
    private static final String BASE_URL = "https://api.tosanboom.com:4432/v1";

    private final ServiceUtil serviceUtil;

    @Autowired
    public DrivingInquiryService(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    public PointLicenseDto getPointLicenseNumberInquiry(String licenseNumber) {
        PointLicenseDto pointLicenseDto = new PointLicenseDto();
        try {

            StringBuilder url = new StringBuilder();
            url.append(BASE_URL);
            url.append("/bills/rahvar/points/");
            url.append(licenseNumber);
            url.append("/inquiry");

            Request request = serviceUtil.getRequest(url);

            Response response = serviceUtil.getResponse(request);

            Optional<ResponseBody> responseBodyVal = Optional.ofNullable(response.body());
            if (responseBodyVal.isPresent()) {
                String responseBody = responseBodyVal.get().string();
                ObjectMapper jsonMapper = serviceUtil.getObjectMapper();
                pointLicenseDto = jsonMapper.readValue(responseBody, PointLicenseDto.class);
            }

            pointLicenseDto.setHttpCode(response.code());
            pointLicenseDto.setHttpMsg(response.message());

        } catch (IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException
                | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }
        return pointLicenseDto;
    }

    public FineCarDto getFineCarInquiry(String barCode) {
        FineCarDto fineCarDto = new FineCarDto();
        try {

            StringBuilder url = new StringBuilder();
            url.append(BASE_URL);
            url.append("/bills/rahvar/fines/");
            url.append(barCode);
            url.append("/inquiry");

            Request request = serviceUtil.getRequest(url);

            Response response = serviceUtil.getResponse(request);

            Optional<ResponseBody> responseBodyVal = Optional.ofNullable(response.body());
            if (responseBodyVal.isPresent()) {
                String responseBody = responseBodyVal.get().string();
                ObjectMapper jsonMapper = serviceUtil.getObjectMapper();
                fineCarDto = jsonMapper.readValue(responseBody, FineCarDto.class);
            }

            fineCarDto.setHttpCode(response.code());
            fineCarDto.setHttpMsg(response.message());

        } catch (IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException
                | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }
        return fineCarDto;
    }
}
