package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Serializable> {
    public abstract Appointment findById(int id);
    public abstract List<Appointment> findByIdDepartment(Department department);
    public abstract List<Appointment> findByIdManager(User manager);

}
