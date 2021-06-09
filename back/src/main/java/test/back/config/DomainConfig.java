package test.back.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("test.back.domain")
@EnableJpaRepositories("test.back.repos")
@EnableTransactionManagement
public class DomainConfig {
}
