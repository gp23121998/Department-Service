package com.example.Departmentservice.service;

import com.example.Departmentservice.entity.Department;
import com.example.Departmentservice.entity.Employee;
import com.example.Departmentservice.exception.ResourceNotFoundException;
import com.example.Departmentservice.repository.DepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("http://localhost:8100/employees/departmentid/")
    private String baseUrl;

    @Autowired
    private DepartmentRepo repo;

    @Override
    public Department getDepartmentById(int id) {
        Department department = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        return department;
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> allDepartment = repo.findAll();
        return allDepartment;
    }

    @Override
    public Department addDepartment(Department department) {
        Department save = repo.save(department);
        return save;
    }

    @Override
    public Department updateDepartment(Department department, int id) {
        Department department1 = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        department1.setDepartmentName(department.getDepartmentName());
        Department save = repo.save(department1);
        return save;
    }

    @Override
    public void deleteDepartment(int id) {
      repo.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeeByDepartmentId(int deparmentId) {

        ArrayList employeeList = restTemplate.getForEntity(baseUrl + deparmentId, ArrayList.class).getBody();
        return employeeList;
    }
}
