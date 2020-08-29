package com.ps.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.ps.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.ps.dao")
public class PersistenceConfig {

	@Bean(name="hkDs")
	public DataSource createDataSource() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("manager");
		ds.setIdleTimeout(30000);
		ds.setMaximumPoolSize(20);
		ds.setMinimumIdle(4);
		return ds;
	}
	
	@Bean(name="sesfact")
	public LocalSessionFactoryBean createLocalSesFactBean() {
		LocalSessionFactoryBean sesFact=null;
		Properties props=null;
		
		sesFact=new LocalSessionFactoryBean();
		sesFact.setDataSource(createDataSource());
		sesFact.setAnnotatedClasses(Project.class);
		props=new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		sesFact.setHibernateProperties(props);
		return sesFact;		
	}
	
	@Bean(name="ht")
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createLocalSesFactBean().getObject());
	}
}
