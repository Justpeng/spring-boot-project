package com.just.rocketmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.just.shardingsphere.health.dao")
public class ShardingSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereApplication.class, args);
	}

}
