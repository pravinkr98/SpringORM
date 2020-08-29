package com.ps.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.ps.entity.Project;

@Configuration
public class PersistenceConfig {

	@Autowired
	private DataSource ds;
	
	@Bean(name="sesfact")
	public LocalSessionFactoryBean createLocalSesFactBean() {
		LocalSessionFactoryBean sesFact=null;
		Properties props=null;
		
		sesFact=new LocalSessionFactoryBean();
		sesFact.setDataSource(ds);
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
