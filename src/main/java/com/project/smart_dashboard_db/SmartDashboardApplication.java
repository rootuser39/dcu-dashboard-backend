package com.project.smart_dashboard_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class SmartDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartDashboardApplication.class, args);
    }
}