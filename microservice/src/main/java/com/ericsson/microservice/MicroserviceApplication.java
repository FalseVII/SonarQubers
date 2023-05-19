package com.ericsson.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "package com.ericsson.entity.SecuritySummary.class")
@SpringBootApplication
public class MicroserviceApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceApplication.class, args);
    }

}
