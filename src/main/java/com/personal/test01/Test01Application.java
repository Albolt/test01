package com.personal.test01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Date;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Test01Application {

    public static void main(String[] args) {
        SpringApplication.run(Test01Application.class, args);
    }



}
