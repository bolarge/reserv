package com.peyspec.reserv.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UsersApp {

    public static void main(String[] args){
        SpringApplication.run(UsersApp.class, args);
    }
}
