package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.User;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestAppointment {

    @Autowired
    @Qualifier("appointmentService")
    private AppointmentService appointmentService;
    @PostMapping("/user/appointment")
    public ResponseEntity<?> insertCategoryNew (@RequestBody AppointmentDTO appointmentDTO)
    {
        appointmentService.addAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);

    }

    @GetMapping("/all/appointments")
    public ResponseEntity<?> getAppointments() {
        boolean exist = appointmentService.listAllAppointments()!=null;
        if(exist) {
            List<AppointmentDTO> product=appointmentService.listAllAppointments();
            return ResponseEntity.ok(product);
        }
        else
            return ResponseEntity.noContent().build();

    }
}
