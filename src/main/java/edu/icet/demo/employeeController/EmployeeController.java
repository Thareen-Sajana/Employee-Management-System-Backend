package edu.icet.demo.employeeController;

import edu.icet.demo.dto.Employee;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employee")
@Slf4j
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

    @PostMapping("add")
    public void add(@RequestBody Employee employee){
        employeeList.add(employee);
        log.info(employeeList.toString());
    }

    @GetMapping("all")
    public List<Employee> getAll(){
        return employeeList;
    }
}
