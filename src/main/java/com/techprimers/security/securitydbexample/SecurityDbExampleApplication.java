package com.techprimers.security.securitydbexample;

import java.io.IOException;
import java.util.Properties;


import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.techprimers.security.securitydbexample.*")
public class SecurityDbExampleApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDbExampleApplication.class, args);
	}

	Logger LOGGER = LoggerFactory.getLogger(SecurityDbExampleApplication.class);

	@Autowired(required = true)
	private Environment env;



	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dSource) throws IOException {
		Properties pro = new Properties();
		pro.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		pro.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dSource);
		factory.setHibernateProperties(pro);
		// factory.setAnnotatedPackages("*");
		factory.setPackagesToScan(new String[]{""});
		factory.afterPropertiesSet();
		SessionFactory factorybean = factory.getObject();
		return factorybean;
	}

	@Bean(name = "dataSource")
	public DataSource getDatasource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getProperty("class-driver"));
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Autowired
	@Bean(name = "hibernateTransactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
		manager.setNestedTransactionAllowed(true);
		return manager;
	}
	
    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    //     return new WebMvcConfigurerAdapter() {
    //         @Override
    //         public void addCorsMappings(CorsRegistry registry) {
    //             registry.addMapping("/**").allowedOrigins("http://localhost:33475","/**","**").allowedMethods("POST", "GET","PUT","DELETE");
    //         }
    //     };
    // }
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Application running .....  from logger");



	}

}
