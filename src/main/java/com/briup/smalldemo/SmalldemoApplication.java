package com.briup.smalldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描当前目录的子目录
@MapperScan({"com.briup.smalldemo.mapper","com.briup.smalldemo.mapper.ex"})
@SpringBootApplication
public class SmalldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmalldemoApplication.class, args);
    }

}
