package com.vu.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vu.service.base.Connection;
import com.vu.service.dto.FineCarDto;
import com.vu.service.dto.PointLicenseDto;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
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

    public PointLicenseDto getPointLicenseNumberInquiry(String licenseNumber) {
        PointLicenseDto pointLicenseDto = new PointLicenseDto();
        try {

            StringBuilder url = new StringBuilder();
            url.append(BASE_URL);
            url.append("/bills/rahvar/points/");
            url.append(licenseNumber);
            url.append("/inquiry");

            Request request = new Request.Builder().url(String.valueOf(url))
                    .addHeader("App-Key", "12345")
                    .addHeader("Device-Id", "123456789")
                    .addHeader("Token-Id", "e95322d8e84fee716c94380db8d0b86a")
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "fa")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Client-Ip-Address", "192.168.1.1")
                    .addHeader("Client-Platform-Type", "WEB")
                    .addHeader("Client-User-Id", "09121234567")
                    .addHeader("Client-User-Agent", "Mozilla Firefox 65.0.2")
                    .addHeader("Client-Device-Id", "192.168.1.1")
                    .get().build();

            Response response = new Connection()
                    .getSSLConnect("123456", "tosanboom.jks").newCall(request).execute();

            Optional<ResponseBody> responseBodyVal = Optional.ofNullable(response.body());
            if (responseBodyVal.isPresent()) {
                String responseBody = responseBodyVal.get().string();
                ObjectMapper jsonMapper = new ObjectMapper();
                jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                jsonMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
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

            Request request = new Request.Builder().url(String.valueOf(url))
                    .addHeader("App-Key", "12345")
                    .addHeader("Device-Id", "123456789")
                    .addHeader("Token-Id", "e95322d8e84fee716c94380db8d0b86a")
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "fa")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Client-Ip-Address", "192.168.1.1")
                    .addHeader("Client-Platform-Type", "WEB")
                    .addHeader("Client-User-Id", "09121234567")
                    .addHeader("Client-User-Agent", "Mozilla Firefox 65.0.2")
                    .addHeader("Client-Device-Id", "192.168.1.1")
                    .get().build();

            Response response = new Connection()
                    .getSSLConnect("123456", "tosanboom.jks").newCall(request).execute();

            Optional<ResponseBody> responseBodyVal = Optional.ofNullable(response.body());
            if (responseBodyVal.isPresent()) {
                String responseBody = responseBodyVal.get().string();
                ObjectMapper jsonMapper = new ObjectMapper();
                jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                jsonMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
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
