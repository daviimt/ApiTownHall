package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Serializable> {
    public abstract Appointment findById(int id);
    public abstract List<Appointment> findByIdDepartment(int idDepartment);
    public abstract List<Appointment> findByIdManager(int idManager);

}
