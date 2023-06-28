package com.AppRh.AppRh;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/apprh?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword(null);
		return dataSource;
		
	}
	@Bean
      public JpaVendorAdapter jpaVendorAdapter() {
    	  HibernateJpaVendorAdapter adapter = new  HibernateJpaVendorAdapter();
    	  adapter.setDatabase(Database.MYSQL);
    	  adapter.setShowSql(true);
    	  adapter.setGenerateDdl(true);
    	  adapter.setDatabasePlatform("org.hibernate.dialect.MariaDB103Dialect");
    	  adapter.setPrepareConnection(true);
    	  return adapter;
      }
	
  @Bean
public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager();
}
}
    
    
    
    
    
    
