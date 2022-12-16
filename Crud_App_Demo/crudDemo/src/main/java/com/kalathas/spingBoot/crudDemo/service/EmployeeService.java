package com.kalathas.spingBoot.crudDemo.service;

import com.kalathas.spingBoot.crudDemo.model.Employee;
import com.kalathas.spingBoot.crudDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {


    EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> deleteEmployee(Integer id) {
        Optional<Employee> temp = getEmployee(id);
        employeeRepository.deleteById(id);
        return temp;
    }


}
