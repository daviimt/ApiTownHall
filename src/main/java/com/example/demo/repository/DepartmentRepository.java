package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Serializable> {

    public  abstract Department findById(int id);
}
