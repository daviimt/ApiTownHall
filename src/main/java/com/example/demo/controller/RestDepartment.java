package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.models.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestDepartment {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @GetMapping("/all/departments")
    public ResponseEntity<?> getDepartments() {
        boolean exist = departmentService.listAllDepartments()!=null;
        if(exist) {
            List<DepartmentDTO> departments=departmentService.listAllDepartments();
            return ResponseEntity.ok(departments);
        }
        else
            return ResponseEntity.noContent().build();

    }

    @GetMapping("/all/department/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable int id) {
        boolean exist = departmentService.findDepartmentById(id)!=null;
        System.out.println(exist);
        System.out.println(departmentService.findDepartmentById(id));
        if(exist) {
            Department department=departmentService.findDepartmentById(id);
            return ResponseEntity.ok(department);
        }
        else
            return ResponseEntity.noContent().build();

    }
}
