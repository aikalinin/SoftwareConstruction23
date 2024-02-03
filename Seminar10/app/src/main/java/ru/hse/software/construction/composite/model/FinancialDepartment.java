package ru.hse.software.construction.composite.model;

import lombok.Data;

@Data
public class FinancialDepartment implements Department {

    private Integer id;

    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}