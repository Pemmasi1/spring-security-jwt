package com.siva.security.service;



import com.siva.security.dao.EmployeeDao;
import com.siva.security.domain.Employee;
import com.siva.security.pojo.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee addEmployee(EmployeeDto employee);

//    Employee updateEmployee(Employee employee);
//
//    boolean deleteEmployee(int empno);

    Optional<Employee> getEmployeeById(int empno);

//    List<Employee> search(String str);
//
//    List<Employee> getEmployeesByDeptno(int deptno);
//
//    List<Employee> addEmployees(List<Employee> list);
}
