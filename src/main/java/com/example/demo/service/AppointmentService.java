package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.models.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    public abstract AppointmentDTO addAppointment(AppointmentDTO categoryDTO);
    public abstract List<AppointmentDTO> listAllAppointments();
    public abstract Appointment findAppointmentById(int id);
    public abstract List<AppointmentDTO> findAppointmentByIdManager(int idManager);
    public abstract List<AppointmentDTO> findAppointmentByIdDepartment(int idDepartment);
    public abstract boolean removeAppointment(int id);
    public abstract Appointment transform(AppointmentDTO categoryDTO);
    public abstract AppointmentDTO transform(Appointment category);
}
