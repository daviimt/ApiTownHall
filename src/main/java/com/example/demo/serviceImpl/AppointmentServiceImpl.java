package com.example.demo.serviceImpl;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    @Qualifier("appointmentRepository")
    private AppointmentRepository appointmentRepository;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        appointmentRepository.save(transform(appointmentDTO));
        return appointmentDTO;

    }

    @Override
    public List<AppointmentDTO> listAllAppointments() {
        return appointmentRepository.findAll().stream().
                map(c -> transform(c)).collect(Collectors.toList());
    }

    @Override
    public Appointment findAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<AppointmentDTO> findAppointmentByIdManager(int idManager) {
        User us = userService.findUserId(idManager);
        return appointmentRepository.findByIdManager(us).stream().map(a -> transform(a)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentByIdDepartment(int idDepartment) {
        Department dep = departmentService.findDepartmentById(idDepartment);
        return appointmentRepository.findByIdDepartment(dep).stream().map(a -> transform(a)).collect(Collectors.toList());
    }

    @Override
    public boolean removeAppointment(int id) {
        if(appointmentRepository.findById(id)!=null) {
            appointmentRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public Appointment transform(AppointmentDTO appointmentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(appointmentDTO, Appointment.class);
    }

    @Override
    public AppointmentDTO transform(Appointment appointment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(appointment, AppointmentDTO.class);
    }
}
