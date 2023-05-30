package com.example.demo.controller;

import com.example.demo.entity.Report;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.models.ReportDTO;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestReport {

    @Autowired
    @Qualifier("reportService")
    private ReportService reportService;

    @GetMapping("/all/reports")
    public ResponseEntity<?> getReports() {
        boolean exist = reportService.listAllReports()!=null;
        if(exist) {
            List<ReportDTO> product=reportService.listAllReports();
            return ResponseEntity.ok(product);
        }
        else
            return ResponseEntity.noContent().build();

    }
    @GetMapping("/manager/reports/{idAppointment}")
    public ResponseEntity<?> getReportsAppointment(@PathVariable int idAppointment) {
        boolean exist = reportService.findReportByIdAppointment(idAppointment)!=null;
        if(exist) {
            List<ReportDTO> reports=reportService.findReportByIdAppointment(idAppointment);
            return ResponseEntity.ok(reports);
        }
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/manager/report/{idReport}")
    public ResponseEntity<?> getReport(@PathVariable int idReport) {
        boolean exist = reportService.findReportById(idReport)!=null;
        if(exist) {
            Report report=reportService.findReportById(idReport);
            return ResponseEntity.ok(report);
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/manager/report")
    public ResponseEntity<?> insertReportNew (@RequestBody ReportDTO reportDTO)
    {
        reportService.addReport(reportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportDTO);

    }


    @PutMapping("/manager/report")
    public ResponseEntity<?> updateReportNew (@RequestBody ReportDTO reportDTO)
    {
        reportService.addReport(reportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportDTO);

    }

    @DeleteMapping("/manager/report/{idReport}")
    public ResponseEntity<?> deleteReport(@PathVariable int idReport)
    {
        boolean exists = reportService.removeReport(idReport);
        System.out.println("existe"+exists);
        if(exists) {
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.noContent().build();
    }
}
