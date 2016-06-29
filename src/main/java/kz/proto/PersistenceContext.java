package kz.proto;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "kz.proto.dao.repository" })
@EnableTransactionManagement
class PersistenceContext {


}
