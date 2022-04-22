package com.swen90013;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jerry", "com.swen90013"})
@MapperScan("com.jerry.mapper")
public class demoApplication {
    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class ,args);
    }
}
