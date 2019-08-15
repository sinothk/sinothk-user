package com.sinothk.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 发现服务
@MapperScan("com.sinothk.user.repository")
public class SinothkUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinothkUserApplication.class, args);
    }

}
