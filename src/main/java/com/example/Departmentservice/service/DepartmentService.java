package com.example.Departmentservice.service;


import com.example.Departmentservice.entity.Department;
import com.example.Departmentservice.entity.Employee;


import java.util.List;

public interface DepartmentService {

    //getEmployeeById (get)
    public Department getDepartmentById(int id);

    public List<Department> getAllDepartment();

    //addEmployee (post)
    public Department addDepartment(Department department);

    //updateEmployee (put)
    public Department updateDepartment(Department department, int id);

    //deleteEmployee(delete)
    public void deleteDepartment(int id);

    List<Employee> getEmployeeByDepartmentId(int departmentId);
}
