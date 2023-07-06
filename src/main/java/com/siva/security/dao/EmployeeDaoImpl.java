package com.siva.security.dao;


import com.siva.security.domain.Employee;
import com.siva.security.domain.EmployeeRepository;
import com.siva.security.pojo.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    private static final String ADD_EMP = "insert into employee(emp_name,emp_salary,dept_no) values(?,?,?)";
    private static final String GET_EMPLOYEES = "select emp_no,emp_name,emp_salary,dept_no from employee";

    private static final String GET_EMP_BY_ID = "select emp_no,emp_name,emp_salary,dept_no from employee where emp_no=?";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> list = employeeRepository.findAll();
        log.info("Employee count :{}", list.size());
        return list;
    }

    @Override
    @Transactional
    public Employee addEmployee(EmployeeDto employee) {
        Employee employee1 = new Employee();
        employee1.setDeptNo(employee.getDeptNo());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1 = employeeRepository.save(employee1);
        log.info("Employee {} is added with id {}", employee.getEmpName(), employee1.getEmpNo());
        return employee1;
    }

    @Override
    public Optional<Employee> findById(int empno) {
        try {
           Optional<Employee> employee = employeeRepository.findById(empno);
           return employee;
            } catch (IndexOutOfBoundsException exp) {
            throw new RuntimeException(String.format("Employee %s is not present in DB", empno));
        }
    }

    @Override
    public List<Employee> findByDeptNo(int deptNo) {
        return employeeRepository.findByDeptNo(deptNo);
    }

}
