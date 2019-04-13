package com.vu.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vu.service.base.Connection;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@Component
public class ServiceUtil {
    public ObjectMapper getObjectMapper() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return jsonMapper;
    }

    public Request getRequest(StringBuilder url) {
        return new Request.Builder().url(String.valueOf(url))
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
    }

    public Response getResponse(Request request) throws IOException, KeyStoreException, CertificateException,
            NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
        return new Connection()
                .getSSLConnect("123456", "tosanboom.jks").newCall(request).execute();
    }
}
