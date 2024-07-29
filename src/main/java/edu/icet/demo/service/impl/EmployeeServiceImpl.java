package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.Employee;
import edu.icet.demo.entity.EmployeeEntity;
import edu.icet.demo.repository.EmployeeRepository;
import edu.icet.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository repository;
    private final ObjectMapper mapper;
    @Override
    public void addEmployee(Employee employee) {
        repository.save(mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = repository.findAll();

        employeeEntities.forEach(employeeEntity ->
                employeeList.add(mapper.convertValue(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public void deleteEmployee(Long id) {
        if(repository.existsById(id)) repository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repository.findById(employee.getId()).isPresent())
            repository.save(mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public Employee findById(Long id) {

        if(repository.findById(id).isPresent())
            return mapper.convertValue(repository.findById(id), Employee.class);
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return mapper.convertValue(repository.findByFirstName(firstName), Employee.class);
    }
}
