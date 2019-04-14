package com.vu.service.base;

import okhttp3.OkHttpClient;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

public class Connection {
    private static final OkHttpClient.Builder HTTP_CLIENT = new OkHttpClient().newBuilder();

    public OkHttpClient getSSLConnect(String trustPass, String trustStoreFileAddress) throws KeyStoreException,
            CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException,
            KeyManagementException {

        KeyStore keyStore = KeyStore.getInstance("JKS");//JKS key store type
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(trustStoreFileAddress);

        keyStore.load(inputStream, trustPass.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("SSL");

        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore, trustPass.toCharArray());

        TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustFactory.init(keyStore);

        sslContext.init(factory.getKeyManagers(), trustFactory.getTrustManagers(), new SecureRandom());

        return HTTP_CLIENT.connectTimeout(200, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustFactory.getTrustManagers()[0])
                .build();
    }
}
