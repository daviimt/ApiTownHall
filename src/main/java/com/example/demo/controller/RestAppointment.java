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

    @GetMapping("/manager/appointments{idManager}")
    public ResponseEntity<?> getAppointmentsManager(@PathVariable int idManager) {
        boolean exist = appointmentService.findCAppointmentByIdManager(idManager)!=null;
        if(exist) {
            List<AppointmentDTO> appointments=appointmentService.findCAppointmentByIdManager(idManager);
            return ResponseEntity.ok(appointments);
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/appointment")
    public ResponseEntity<?> updateAppointmentNew (@RequestBody AppointmentDTO appointmentDTO)
    {
        appointmentService.addAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);

    }

    @DeleteMapping("/all/appointment/{idAppointment}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int idAppointment)
    {
        boolean exists = appointmentService.removeAppointment(idAppointment);
        if(exists)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.noContent().build();
    }
}
