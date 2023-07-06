package com.siva.security.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    private int deptNo;
    private String dName;
    private String location;

}
