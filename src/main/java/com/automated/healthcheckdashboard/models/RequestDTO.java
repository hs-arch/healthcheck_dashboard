package com.automated.healthcheckdashboard.models;

import java.util.Collections;
import java.util.List;

public class RequestDTO {

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    private List<String> urls;


}
