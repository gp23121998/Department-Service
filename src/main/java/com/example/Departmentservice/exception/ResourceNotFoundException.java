package com.example.Departmentservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    int fieldValue;
    public ResourceNotFoundException(String resourceName, String id, int id1) {
        super(String.format("%s not Found with %s :%s",resourceName,id,id1));
        this.resourceName=resourceName;
        this.fieldName=id;
        this.fieldValue=id1;

    }
}
