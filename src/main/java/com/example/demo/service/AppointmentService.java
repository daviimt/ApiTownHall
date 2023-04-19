package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.models.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    public abstract AppointmentDTO addAppointment(AppointmentDTO categoryDTO);
    public abstract List<AppointmentDTO> listAllAppointments();
    public abstract Appointment findAppointmentById(int id);
    public abstract List<AppointmentDTO> findCAppointmentByIdManager(int id);
    public abstract List<AppointmentDTO> findCAppointmentByIdDepartment(int id);
    public abstract boolean removeAppointment(int id);
    public abstract Appointment transform(AppointmentDTO categoryDTO);
    public abstract AppointmentDTO transform(Appointment category);
}
