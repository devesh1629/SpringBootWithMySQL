package com.example.crudUsingMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.example.crudUsingMySQL")
@ComponentScan(basePackages = {"com.example.crudUsingMySQL",
							"com.example.crudUsingMySQL.repository",
							"com.example.crudUsingMySQL.configs"
})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableCaching
public class CrudUsingMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsingMySqlApplication.class, args);
	}

}
