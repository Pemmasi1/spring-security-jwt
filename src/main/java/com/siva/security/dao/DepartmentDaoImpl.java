package com.siva.security.dao;


import com.siva.security.domain.Department;
import com.siva.security.domain.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        log.info("Department count is {}",departments.size());
        return departments;
    }
}
