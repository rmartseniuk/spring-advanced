package com.epam.martseniuk.config.persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Roman_Martseniuk
 */
//@Configuration
//@EnableJpaRepositories(basePackages = "com.epam.martseniuk")
//@Profile("dev")
public class PersistenceMySqlConfig {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
//        emFactory.setDataSource(dataSource());
//        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
//        emFactory.setJpaProperties(jpaProperties);
//        emFactory.setPackagesToScan("com.epam.martseniuk.entity");
//        return emFactory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }

}
