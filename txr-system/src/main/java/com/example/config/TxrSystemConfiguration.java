package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import(value = {JpaConfiguration.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(
        basePackages = {"com.example"},
        includeFilters = {},
        excludeFilters = {})
public class TxrSystemConfiguration {


}
