package com.kalathas.spingBoot.crudDemo.controller;


import com.kalathas.spingBoot.crudDemo.model.Dto.EmployeeDto;
import com.kalathas.spingBoot.crudDemo.model.Employee;
import com.kalathas.spingBoot.crudDemo.service.EmployeeService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Data
@RequestMapping("/Employees")
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeDto>> findAll(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        List<EmployeeDto> allEmployeesDtos = allEmployees.stream().map(EmployeeDto:: from).collect(Collectors.toList());

        return new ResponseEntity<>(allEmployeesDtos, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<EmployeeDto>> findBid(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.getEmployee(id);


        return new ResponseEntity<>(, HttpStatus.OK);
    }
}
