package at.activesolution.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "at.activesolution")
public class JpaConfiguration {

    private static final String SPRINGBOOT = "springboot";

    private static final String PACKAGES_TO_SCAN = "at.activesolution";

    protected static final String SPRING_JPA_DATABASE_PLATFORM = "spring.jpa.database-platform";

    protected static final String SPRING_HIBERNATE_DIALECT = "hibernate.dialect";

    protected static final String SPRING_JPA_SHOW_SQL = "spring.jpa.show-sql=true";

    @Inject
    private ApplicationPropertyConfiguration applicationPropertyConfiguration;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        final JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setDataSource(dataSource());
        emf.setPersistenceUnitName(SPRINGBOOT);
        emf.setPackagesToScan(PACKAGES_TO_SCAN);
        emf.setJpaProperties(additionalProperties());
        return emf;
    }

    @Bean
    @Primary
    public DataSource dataSource() {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(applicationPropertyConfiguration.getSpringDatasourceDriverClassName());
        dataSource.setUrl(applicationPropertyConfiguration.getSpringDatasourceUrl());
        dataSource.setUsername(applicationPropertyConfiguration.getSpringDatasourceUsername());
        dataSource.setPassword(applicationPropertyConfiguration.getSpringDatasourcePassword());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

        return new PersistenceExceptionTranslationPostProcessor();
    }

    protected Properties additionalProperties() {

        final Properties properties = new Properties();
        properties.setProperty(SPRING_JPA_DATABASE_PLATFORM,
                applicationPropertyConfiguration.getSpringJpaDatabasePlatform());
        properties.setProperty(SPRING_HIBERNATE_DIALECT, "org.hibernate.dialect.Oracle12cDialect");
        properties.setProperty(SPRING_JPA_SHOW_SQL, applicationPropertyConfiguration.getSpringJpaShowSql());
        return properties;
    }

}
