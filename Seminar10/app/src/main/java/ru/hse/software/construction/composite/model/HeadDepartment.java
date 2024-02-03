package ru.hse.software.construction.composite.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HeadDepartment implements Department {

    private Integer id;

    private String name;

    private List<Department> childDepartments;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    public void printDepartmentName() {
        System.out.println("Done!");
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}