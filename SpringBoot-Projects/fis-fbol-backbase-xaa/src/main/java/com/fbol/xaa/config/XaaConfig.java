package com.fbol.xaa.config;

import javax.naming.NamingException;
import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class XaaConfig {
   
  @Value("${spring.datasource.driver-class-name}")
  private String dbdriver;

  @Value("${spring.datasource.url}")
  private String dbconnurl;

  @Value("${spring.datasource.username}")
  private String dbuser;

  @Value("${spring.datasource.password}")
  private String dbpass;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(datasource());
    return sessionFactory.getObject();
  }



  public DataSource datasource() {
    return DataSourceBuilder.create()
            .driverClassName(dbdriver)
            .url(dbconnurl)
            .username(dbuser)
            .password(dbpass)
            .build();
  }



}