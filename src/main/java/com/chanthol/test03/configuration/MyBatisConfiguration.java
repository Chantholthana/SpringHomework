package com.chanthol.test03.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Configuration
@MapperScan("com.chanthol.test03.repository")

public class MyBatisConfiguration {

    private DataSource dataSource;
    public MyBatisConfiguration(DataSource dataSource){
        this.dataSource=dataSource;

    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

}
