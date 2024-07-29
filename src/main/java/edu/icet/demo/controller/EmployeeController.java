package edu.icet.demo.controller;

import edu.icet.demo.dto.Employee;
import edu.icet.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Deleted";
    }

    @PatchMapping("update")
    public void update(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @GetMapping("findById/{id}")
    public Employee findById(@PathVariable Long id){
        return service.findById(id);
    }
}
