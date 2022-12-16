package com.kalathas.spingBoot.crudDemo.model.Dto;


import com.kalathas.spingBoot.crudDemo.model.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public static EmployeeDto from(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employeeDto.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }

}
