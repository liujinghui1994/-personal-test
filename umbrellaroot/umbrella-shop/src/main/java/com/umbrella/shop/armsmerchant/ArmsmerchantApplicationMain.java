package com.umbrella.shop.armsmerchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages="com.umbrella.*")
@MapperScan("com.umbrella.*")
@ComponentScan(basePackages = {"com.umbrella.*"})
public class ArmsmerchantApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ArmsmerchantApplicationMain.class, args);
    }
}
