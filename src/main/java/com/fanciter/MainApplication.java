package com.fanciter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.fanciter.server.graphql.util.GraphQLServerMain;

@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.fanciter"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.fanciter.data.db.mapper"})
public class MainApplication extends GraphQLServerMain {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLServerMain.class);
    }
}
