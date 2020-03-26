package com.aims.ser;

import com.aims.ser.config.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/****
 * @Author: Steven Lee
 * @Description:
 * @Date: 2020/3/15
 *****/
@SpringBootApplication
@ComponentScan(basePackages = {"com.aims.core", "com.aims.ser"})
@MapperScan(basePackages = {"com.aims.core.persistence.mapper"})
@Import({DynamicDataSourceRegister.class})
@EnableCaching
public class AIMSApplication {

    protected final static Logger logger = LoggerFactory.getLogger(AIMSApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AIMSApplication.class, args);
        logger.info("AIMS Application is success!");
    }
}
