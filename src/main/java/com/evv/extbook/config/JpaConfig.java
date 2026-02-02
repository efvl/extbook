package com.evv.extbook.config;

import com.evv.extbook.repository.BaseJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.evv.extbook.repository",
        repositoryBaseClass = BaseJpaRepositoryImpl.class)
public class JpaConfig {

}
