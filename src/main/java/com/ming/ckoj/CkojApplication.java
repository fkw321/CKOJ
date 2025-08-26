package com.ming.ckoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.ming.ckoj.mapper")
public class CkojApplication {

    public static void main(String[] args) {
        SpringApplication.run(CkojApplication.class, args);
    }

}
