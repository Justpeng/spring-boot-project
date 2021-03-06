package com.just.rocketmq;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan(basePackages = "com.just.shardingsphere.health.dao")
public class ShardingSphereDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereDBApplication.class, args);
	}

}
