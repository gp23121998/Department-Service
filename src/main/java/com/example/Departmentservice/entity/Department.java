package com.example.Departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Department_Table")
public class Department {
    @Id
    @Column(name="Department_ID")
    private int departmentId;

    @Column(name="Employee_ID")
    private int employeeId;

    @Column(name="Department_Name")
    private String departmentName;

}
