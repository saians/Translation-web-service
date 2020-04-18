package com.some.task.demorecordmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoRecordManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRecordManagementApplication.class, args);
	}

}
