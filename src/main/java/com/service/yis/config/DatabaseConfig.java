package com.service.yis.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");

        /*aws*/
        dataSourceBuilder.username("yis");
        dataSourceBuilder.password("");
        dataSourceBuilder.url("jdbc:mysql://:3306/yis?useSSL=false&serverTimezone=UTC");


        /* 로컬 */
        //dataSourceBuilder.username("root");
        //dataSourceBuilder.password("20582962");
        //dataSourceBuilder.url("jdbc:mysql://localhost:3333/yis?useSSL=false&serverTimezone=UTC");
        return dataSourceBuilder.build();
    }
}
