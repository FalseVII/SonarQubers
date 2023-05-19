package com.ericsson.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "package com.ericsson.entity.SecuritySummary.class")
@SpringBootApplication
@EntityScan({ "com.ericsson.entity" })
public class MicroserviceApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceApplication.class, args);
    }

}
