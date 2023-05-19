package com.example.twodatabases.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.twodatabases.teacherrepo", 
    entityManagerFactoryRef = "teacherEntityManager", 
    transactionManagerRef = "teacherTransactionManager"
)
public class TeacherConfig {
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource2") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.example.twodatabases.model").persistenceUnit("Teacher").build();
	}

	@Bean(name = "bookTransactionManager")
	public PlatformTransactionManager bookTransactionManager(
			@Qualifier("teacherEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory);
	}
}
