package com.automated.healthcheckdashboard.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_check")
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String status;
    private LocalDateTime checkedAt;

    public HealthCheck(){}

    public HealthCheck(String url, String status, LocalDateTime checkedAt) {
        this.url = url;
        this.status = status;
        this.checkedAt = checkedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }





}
