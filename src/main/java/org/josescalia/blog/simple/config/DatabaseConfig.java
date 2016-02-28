package org.josescalia.blog.simple.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by josescalia on 06/03/15.
 */
@Configuration
public class DatabaseConfig{
    static Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    @Value("${spring.datasource.driver}")
    private String databaseDriver;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.hbm2ddl}")
    private String hbm2Ddl;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePassword;




    @Value("${spring.datasource.dialect}")
    private String hibernateDialect;

    @Scope(value = "singleton")
    public DataSource getDataSource() {
        logger.info("-------------Setting datasource-----------");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(databaseDriver);
        ds.setUrl(databaseUrl);
        ds.setUsername(databaseUser);
        ds.setPassword(databasePassword);
        logger.info("---------datasource setting done-----------");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        logger.info("-------------Setting ORM-----------");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("org.josescalia.blog.simple.model");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        logger.info("---------orm setting done-----------");
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        logger.info("---------setting transactional db connection------------");
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        logger.info("--------setting transactional db connection done--------");
        return transactionManager;
    }

    final Properties additionalProperties() {
        logger.info("additional properties invoked");
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2Ddl);
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        logger.info("-----additional hibernate properties done---------");
        return hibernateProperties;
    }
}
