package com.example.integration;

import com.example.integration.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MavenIntegrationTestDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MavenIntegrationTestDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner onStart(final EmployeeRepository repository) {
    return (String[] args) -> repository.findAll().forEach(employee -> log.info(employee.toString()));
  }
}
