package com.sinothk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 发现服务
public class SinothkUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinothkUserApplication.class, args);
    }

}
