package com.example.demo.controller;

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

    @GetMapping("/all/appointments")
    public ResponseEntity<?> getAppointments() {
        boolean exist = appointmentService.listAllAppointments()!=null;
        if(exist) {
            List<AppointmentDTO> appointments=appointmentService.listAllAppointments();
            return ResponseEntity.ok(appointments);
        }
        else
            return ResponseEntity.noContent().build();

    }
    @GetMapping("/manager/appointments/{id}")
    public ResponseEntity<?> getAppointmentsManager(@PathVariable int id) {

        boolean exist = appointmentService.findAppointmentById(id)!=null;
        System.out.println(exist);
        if(exist) {
            List<AppointmentDTO> appointments=appointmentService.findAppointmentByIdManager(id);
            System.out.println(appointments);
            return ResponseEntity.ok(appointments);
        }
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/appointments/{id}")
    public ResponseEntity<?> getAppointmentsUser(@PathVariable int id) {

        boolean exist = appointmentService.findAppointmentById(id)==null;
        System.out.println(exist);
        if(exist) {
            List<AppointmentDTO> appointments=appointmentService.findAppointmentByIdUser(id);
            return ResponseEntity.ok(appointments);
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/appointment")
    public ResponseEntity<?> insertAppointmentNew (@RequestBody AppointmentDTO appointmentDTO)
    {
        appointmentService.addAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);

    }


    @PutMapping("/user/appointment")
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
