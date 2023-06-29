package dev.patika.week5assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Week5AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week5AssignmentApplication.class, args);
    }

}
