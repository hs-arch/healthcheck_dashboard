package com.automated.healthcheckdashboard.repository;

import com.automated.healthcheckdashboard.entity.HealthCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {
}
