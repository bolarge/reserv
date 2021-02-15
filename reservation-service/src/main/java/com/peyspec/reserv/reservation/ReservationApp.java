package com.peyspec.reserv.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReservationApp {

    public static void main(String[] args){
        SpringApplication.run(ReservationApp.class, args);
    }
}
