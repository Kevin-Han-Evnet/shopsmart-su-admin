package com.fiveone.shopsmart.suadmin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    /**
     *  shopsmart_db DB
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.shopsmart-suport")
    public DataSource shopsmartSupportDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactoryShopsmartSupport")
    public LocalContainerEntityManagerFactoryBean shopsmartSupportEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder.dataSource(shopsmartSupportDataSource())
                .packages("com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerShopsmartSupport")
    PlatformTransactionManager shopsmartSupportTransactionManagerMain(
            EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(shopsmartSupportEntityManagerFactory(builder).getObject());
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages= "com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_support",
            entityManagerFactoryRef = "entityManagerFactoryShopsmartSupport",
            transactionManagerRef = "transactionManagerShopsmartSupport")
    static class ShopsmartSupportJpaRepositoriesConfig {
        //noting yet;
    }



    /**
     *  shopsmart-new DB
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.shopsmart-new")
    public DataSource shopsmartNewDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryShopsmartNew")
    public LocalContainerEntityManagerFactoryBean shopsmartNewEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder.dataSource(shopsmartNewDataSource())
                .packages("com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_new")
                .build();
    }

    @Bean(name = "transactionManagerShopsmartNew")
    PlatformTransactionManager shopsmartNewTransactionManagerMain(
            EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(shopsmartNewEntityManagerFactory(builder).getObject());
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages= "com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_new",
            entityManagerFactoryRef = "entityManagerFactoryShopsmartNew",
            transactionManagerRef = "transactionManagerShopsmartNew")
    static class ShopsmartNewJpaRepositoriesConfig {
        //noting yet;
    }

}
