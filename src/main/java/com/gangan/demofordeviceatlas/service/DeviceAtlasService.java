package com.gangan.demofordeviceatlas.service;

import com.gangan.demofordeviceatlas.dto.DeviceAtlasResponse;
import com.gangan.demofordeviceatlas.entity.DeviceInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DeviceAtlasService {
    private final String HOST = "https://region0.deviceatlascloud.com";
    private final String API_PATH = "/v1/detect/properties";
    private final String LICENSE_KEY = "e6ce0b9455cab0e494be4587d016c7c2";

    public DeviceInfo detectUserAgent(String userAgent) {
        WebClient webClient = WebClient.create(HOST);
        DeviceAtlasResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path(API_PATH)
                        .queryParam("licencekey", LICENSE_KEY)
                        .queryParam("useragent", userAgent)
                        .build())
                .retrieve()
                .bodyToMono(DeviceAtlasResponse.class)
                .block();

        return response.getProperties();
    }

}
