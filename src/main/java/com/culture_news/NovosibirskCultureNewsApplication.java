package com.culture_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class NovosibirskCultureNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovosibirskCultureNewsApplication.class, args);
	}

}
