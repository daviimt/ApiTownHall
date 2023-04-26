package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.models.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    public abstract DepartmentDTO addAppointment(DepartmentDTO departmentDTO);

    public abstract List<DepartmentDTO> listAllDepartments();

    public abstract Department findDepartmentById(int id);

    public abstract boolean removeDepartment(int id);

    public abstract Department transform(DepartmentDTO departmentDTO);

    public abstract DepartmentDTO transform(Department department);
}
