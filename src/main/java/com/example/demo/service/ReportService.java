package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Report;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.models.ReportDTO;

import java.util.List;

public interface ReportService {

    public abstract ReportDTO addReport(ReportDTO reportDTO);
    public abstract List<ReportDTO> listAllReports();
    public abstract Report findReportById(int id);
    public abstract List<ReportDTO> findReportByIdAppointment(int id);
    public abstract boolean removeReport(int id);
    public abstract Report transform(ReportDTO reportDTO);
    public abstract ReportDTO transform(Report category);
}
