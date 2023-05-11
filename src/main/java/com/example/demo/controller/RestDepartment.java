package com.example.demo.controller;

import com.example.demo.models.AppointmentDTO;
import com.example.demo.models.DepartmentDTO;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
