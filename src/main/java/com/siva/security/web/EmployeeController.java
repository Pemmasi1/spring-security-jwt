package com.siva.security.web;


import com.siva.security.dao.DepartmentDao;
import com.siva.security.dao.EmployeeDao;
import com.siva.security.domain.Department;
import com.siva.security.domain.Employee;
import com.siva.security.pojo.EmployeeDto;
import com.siva.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/auth/ems")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentDao departmentDao;

    @PostMapping("/addEmployee")
    public ResponseEntity addNewEmploy(@RequestBody EmployeeDto employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getDepartments")
    public List<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @GetMapping("/getEmploye")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }
//    @PostMapping("/addEmployees")
//    public ResponseEntity addEmployees(@RequestBody List<Employee> employee) {
//        employeeService.addEmployees(employee);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/getEmployeesByDept")
    public List<Employee> employeesByDept(@RequestParam int deptNo) {
        return employeeDao.findByDeptNo(deptNo);
    }

//    @PutMapping("/updateEmployee")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
//        return ResponseEntity.ok(employeeService.updateEmployee(employee));
//    }

//    @DeleteMapping("/{empno}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable("emp_no") int empno) {
//        boolean isDeleted = employeeService.deleteEmployee(empno);
//        if (isDeleted) {
//            return ResponseEntity.ok("Deletion of employee is successful");
//        } else {
//            return ResponseEntity.ok("Delete operation failed");
//        }
//    }
    @GetMapping("/{empno}")
    public ResponseEntity<Object> getEmployee(@PathVariable("empno")int empno) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empno));
    }


//    @GetMapping("/search/{str}")
//    public ResponseEntity<List<Employee>> search(@PathVariable("str") String str) {
//        return ResponseEntity.ok(employeeService.search(str));
//    }

}
