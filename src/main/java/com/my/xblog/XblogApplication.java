package com.my.xblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.my.xblog.mapper"})
public class XblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(XblogApplication.class, args);
    }

}
