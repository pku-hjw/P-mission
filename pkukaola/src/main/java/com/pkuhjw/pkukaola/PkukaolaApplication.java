package com.pkuhjw.pkukaola;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pkuhjw.pkukaola"})
@MapperScan("com.pkuhjw.pkukaola.dao")
public class PkukaolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkukaolaApplication.class, args);
    }

}
