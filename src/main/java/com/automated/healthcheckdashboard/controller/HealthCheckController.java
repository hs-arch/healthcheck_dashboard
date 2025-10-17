package com.automated.healthcheckdashboard.controller;

import com.automated.healthcheckdashboard.entity.HealthCheck;
import com.automated.healthcheckdashboard.models.ServiceStatus;
import com.automated.healthcheckdashboard.models.RequestDTO;
import com.automated.healthcheckdashboard.models.UrlConfig;
import com.automated.healthcheckdashboard.repository.HealthCheckRepository;
import com.automated.healthcheckdashboard.service.ScheduledTaskService;
import com.automated.healthcheckdashboard.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableScheduling
@RequestMapping("v1/health")
public class HealthCheckController {

    @Autowired
    WebClientService webClientService;

    @Autowired
    UrlConfig urlConfig;

    @Autowired
    ScheduledTaskService scheduledTaskService;

    @Autowired
    HealthCheckRepository healthCheckRepository;

    @GetMapping("check1")
    public ResponseEntity<String> checkHealth(){
        return ResponseEntity.ok("From health check controller...");
    }

    @GetMapping("status/all")
    public List<ServiceStatus> getAllStatuses(){
        return List.of(
                new ServiceStatus("https:google.com", "UP"),
                new ServiceStatus("https://clicking.toys/flip-grid/neat-nine/3-holes/","UP")
        );
    }

    @PostMapping("/status/check")
    public ResponseEntity<HashMap<String, String>> getStatus(){

        HashMap<String, String> results = new HashMap<>();
        results = scheduledTaskService.manualHealthCheck();

        return ResponseEntity.ok(results);
    }

    @GetMapping("/status/history")
    public ResponseEntity<List<HealthCheck>> getHistory(){
        List<HealthCheck> allHistory = healthCheckRepository.findAll();
//        System.out.println(allHistory);
        return ResponseEntity.ok(allHistory);
    }
}
