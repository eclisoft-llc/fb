package com.fbol.xaabatch.batch.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fbol.xaabatch.batch.JobResultListener;
import com.fbol.xaabatch.batch.XaaReader;
import com.fbol.xaabatch.batch.XaaProcessor;
import com.fbol.xaabatch.model.Xaa;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
   
  @Autowired
  private JobBuilderFactory jobBuilderFactory;
 
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  @StepScope
  private XaaReader xaareader;

  @Value("${spring.datasource.driver-class-name}")
  private String dbdriver;

  @Value("${spring.datasource.url}")
  private String dbconnurl;

  @Value("${spring.datasource.username}")
  private String dbuser;

  @Value("${spring.datasource.password}")
  private String dbpass;


  @Bean
  public Job readFlatFileJob() throws Exception {
    return jobBuilderFactory
        .get("readFlatFileJob")
            .incrementer(new RunIdIncrementer())
        .listener(new JobResultListener())
        .start(step())
        .build();
  }
 
  @Bean
  public Step step() throws Exception {
    return stepBuilderFactory
        .get("step")
        .<Xaa, Xaa>chunk(5000)
        .reader(xaareader.read())
        .processor(processor())
        .writer(writer())
        .build();
  }
   
  @Bean
    public ItemProcessor<Xaa, Xaa> processor() {
    return new XaaProcessor();
    }


  @Bean
  public JdbcBatchItemWriter<Xaa> writer() throws NamingException {
    JdbcBatchItemWriter<Xaa> itemWriter = new JdbcBatchItemWriter<Xaa>();
    itemWriter.setDataSource(datasource());
    itemWriter.setSql("INSERT INTO XAASTATEMENTS(ACCOUNTNUMBER, FULLSTATEMENTNUMBER, STATEMENTDATE, FILENAME) VALUES (:accountnumber, :fullstatementnumber, :statementdate, :filename)");
    itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Xaa>());
    return itemWriter;
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