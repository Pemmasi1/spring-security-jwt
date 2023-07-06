//package com.siva.security.dao.mapper;
//
//
//
//
//import com.siva.security.domain.Employee;
//
//import javax.swing.tree.RowMapper;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class EmployeeRowMapper implements RowMapper<Employee> {
//    @Override
//    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Employee emp = new Employee();
//        emp.setEmpName(rs.getString("emp_name"));
//        emp.setEmpSalary(rs.getFloat("emp_salary"));
//        emp.setDeptNo(rs.getInt("dept_no"));
//        emp.setEmpNo(rs.getInt("emp_no"));
//        return emp;
//    }
//}
