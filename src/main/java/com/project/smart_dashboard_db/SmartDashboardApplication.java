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
    private static final String DATABASE_URL = "jdbc:mysql://ee417db.crxkzf89o3fh.eu-west-1.rds.amazonaws.com/smart_dashboard_db";
    private static final String DATABASE_USERNAME = "EE417";
    private static final String DATABASE_PASSWORD = "EE417_2024";
    private static final String DATABASE_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        System.setProperty("spring.datasource.url", DATABASE_URL);
        System.setProperty("spring.datasource.username", DATABASE_USERNAME);
        System.setProperty("spring.datasource.password", DATABASE_PASSWORD);
        System.setProperty("spring.datasource.driver-class-name", DATABASE_DRIVER_CLASS_NAME);

        SpringApplication.run(SmartDashboardApplication.class, args);
    }
}