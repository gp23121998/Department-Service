package com.example.Departmentservice.controller;

import com.example.Departmentservice.entity.Department;
import com.example.Departmentservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Departmentservice.service.DepartmentServiceImp;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp service;

    //post
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department department1 = service.addDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    //get
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable int id){
        Department DepartmentById = service.getDepartmentById(id);
        return new ResponseEntity<>(DepartmentById, HttpStatus.FOUND);
    }

    //GetAll
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> allDepartment = service.getAllDepartment();
        return new ResponseEntity<>(allDepartment, HttpStatus.OK);
    }

    //GetAllEmployee
    @GetMapping("/employees/{departmentId}")
    public ResponseEntity<List<Employee>> getAllEmployee(@PathVariable int departmentId ){
        List<Employee> allEmployee = service.getEmployeeByDepartmentId(departmentId);
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department department){
        Department department1 = service.updateDepartment(department,id);
        return new ResponseEntity<>(department1, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable int id){
        service.deleteDepartment(id);
        return new ResponseEntity<>(Map.of("message","Department is deleted"),HttpStatus.NO_CONTENT);
    }


}
