package com.emlakcepteservice;

import com.emlakcepteservice.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
@EnableEurekaClient
public class EmlakcepteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmlakcepteServiceApplication.class, args);
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }


}
