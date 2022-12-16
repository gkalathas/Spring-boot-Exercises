package com.kalathas.spingBoot.crudDemo.repository;

import com.kalathas.spingBoot.crudDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
