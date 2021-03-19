package at.activesolution.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
public class ApplicationPropertyConfiguration {

    @Value("${spring.datasource.driver-class-name:oracle.jdbc.OracleDriver}")
    private String springDatasourceDriverClassName;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.datasource.username}")
    private String springDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String springDatasourcePassword;

    @Value("${spring.jpa.database-platform:org.hibernate.dialect.Oracle12cDialect}")
    private String springJpaDatabasePlatform;

    @Value("${spring.jpa.show-sql:false}")
    private String springJpaShowSql;


    public String getSpringDatasourceDriverClassName() {
        return springDatasourceDriverClassName;
    }

    public String getSpringDatasourceUrl() {
        return springDatasourceUrl;
    }

    public String getSpringDatasourceUsername() {
        return springDatasourceUsername;
    }

    public String getSpringDatasourcePassword() {
        return springDatasourcePassword;
    }

    public String getSpringJpaDatabasePlatform() {
        return springJpaDatabasePlatform;
    }

    public String getSpringJpaShowSql() { return springJpaShowSql; }

    public void setSpringDatasourceDriverClassName(String springDatasourceDriverClassName) {
        this.springDatasourceDriverClassName = springDatasourceDriverClassName;
    }

    public void setSpringDatasourceUrl(String springDatasourceUrl) {
        this.springDatasourceUrl = springDatasourceUrl;
    }

    public void setSpringDatasourceUsername(String springDatasourceUsername) {
        this.springDatasourceUsername = springDatasourceUsername;
    }

    public void setSpringDatasourcePassword(String springDatasourcePassword) {
        this.springDatasourcePassword = springDatasourcePassword;
    }

    public void setSpringJpaDatabasePlatform(String springJpaDatabasePlatform) {
        this.springJpaDatabasePlatform = springJpaDatabasePlatform;
    }

    public void setSpringJpaShowSql(String springJpaShowSql) {
        this.springJpaShowSql = springJpaShowSql;
    }
}
