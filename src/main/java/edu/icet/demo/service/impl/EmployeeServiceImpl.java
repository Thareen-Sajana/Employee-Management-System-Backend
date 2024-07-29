package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.Employee;
import edu.icet.demo.entity.EmployeeEntity;
import edu.icet.demo.repository.EmployeeRepository;
import edu.icet.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<EmployeeEntity> getAll() {
        return repository.findAll();
    }
}
