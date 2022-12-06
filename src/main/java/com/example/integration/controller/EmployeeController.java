package com.example.integration.controller;

import com.example.integration.domain.Employee;
import com.example.integration.exception.EmployeeNotFoundException;
import com.example.integration.repository.EmployeeRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class EmployeeController {

  private final EmployeeRepository repository;

  @GetMapping("/employees")
  public Collection<Employee> getAll() throws InterruptedException {
    // emulate long running task
    Thread.sleep(3000L);
    return repository.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee getOne(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
  }
}
