package com.culture_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.culture_news.entity")
@EnableJpaRepositories("com.culture_news.repositories")
public class NovosibirskCultureNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovosibirskCultureNewsApplication.class, args);
	}

}
