package com.automated.healthcheckdashboard.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlConfig {
    private List<String> monitoredUrls = List.of(
            "https://www.google.com",
            "https://www.github.com",
            "https://www.yahoo.com"
    );

    public List<String> getMonitoredUrls() {
        return monitoredUrls;
    }
}
