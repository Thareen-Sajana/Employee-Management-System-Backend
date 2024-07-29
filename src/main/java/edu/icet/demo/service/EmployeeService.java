package edu.icet.demo.service;

import edu.icet.demo.dto.Employee;
import edu.icet.demo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<EmployeeEntity> getAll();
}
