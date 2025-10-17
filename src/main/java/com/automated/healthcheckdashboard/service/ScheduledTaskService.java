package com.automated.healthcheckdashboard.service;

import com.automated.healthcheckdashboard.entity.HealthCheck;
import com.automated.healthcheckdashboard.models.UrlConfig;
import com.automated.healthcheckdashboard.repository.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduledTaskService {

    @Autowired
    UrlConfig urlConfig;

    @Autowired
    WebClientService webClientService;

    @Autowired
    HealthCheckRepository healthCheckRepository;

//    Commenting the scheduled service for now
//    -------------------------------------------------------------------
//    @Scheduled(fixedRate = 60000)
//    public HashMap<String, String> automatedHealthCheck(){
//
//        HashMap<String, String> urlsStatus = new HashMap<>();
//        System.out.println("Automated check running at ----- " + LocalDateTime.now());
//
//        List<String> urls = urlConfig.getMonitoredUrls();
//
//        for(String url : urls){
//            String status = webClientService.checkUrlStatus(url);
//            urlsStatus.put(url, status);
//        }
//
//        return urlsStatus;
//    }

//    This is the one that will be triggered when i hit the API, if not then the above @scheduled method will run as per schedule.
    public HashMap<String, String> manualHealthCheck(){

        HashMap<String, String> urlsStatus = new HashMap<>();
        System.out.println("Automated check running at ----- " + LocalDateTime.now());

        List<String> urls = urlConfig.getMonitoredUrls();

        for(String url : urls){
            String status = webClientService.checkUrlStatus(url);
            urlsStatus.put(url, status);

            HealthCheck healthCheck = new HealthCheck(url, status, LocalDateTime.now());

            healthCheckRepository.save(healthCheck);
        }

        return urlsStatus;
    }

}
