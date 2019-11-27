package com.mybatis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeMapper.findAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeMapper.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity save(@Valid @RequestBody EmployeeRequest request) {
        employeeMapper.insert(new Employee(request.getEmail(), request.getLastName(), request.getEmail()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        employeeMapper.update(new Employee(id, request.getEmail(), request.getLastName(), request.getEmail()));
        return employeeMapper.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        employeeMapper.delete(id);
        return ResponseEntity.noContent().build();
    }
}
