package edu.icet.demo.controller;

import edu.icet.demo.dto.Employee;
import edu.icet.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("add")
    public void add(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("all")
    public List<Employee> getAll(){
        return service.getAll();
    }
}
