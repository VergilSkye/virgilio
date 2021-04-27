package br.com.qualitytecnologia.config;

import br.com.qualitytecnologia.GeneratedByJHipster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tech.jhipster.config.JHipsterConstants;

@Configuration
@EnableJpaRepositories("br.com.qualitytecnologia.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
@GeneratedByJHipster
public class DatabaseConfiguration {}
