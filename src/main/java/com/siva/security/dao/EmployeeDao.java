package com.siva.security.dao;


import com.siva.security.domain.Employee;
import com.siva.security.pojo.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    List<Employee> getEmployees();
    Employee addEmployee(EmployeeDto employee);
    Optional<Employee> findById(int empNo);

    List<Employee> findByDeptNo(int deptNo);
}
