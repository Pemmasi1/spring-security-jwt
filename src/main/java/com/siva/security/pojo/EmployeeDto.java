package com.siva.security.pojo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String empName;
    private float empSalary;
    private int deptNo;
}
