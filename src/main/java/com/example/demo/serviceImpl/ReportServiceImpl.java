package com.example.demo.serviceImpl;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Report;
import com.example.demo.models.AppointmentDTO;
import com.example.demo.models.ReportDTO;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.ReportRepository;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    @Qualifier("reportRepository")
    private ReportRepository reportRepository;

    @Autowired
    @Qualifier("appointmentService")
    private AppointmentService appointmentService;

    @Override
    public ReportDTO addReport(ReportDTO reportDTO) {
        reportRepository.save(transform(reportDTO));
        return reportDTO;
    }

    @Override
    public List<ReportDTO> listAllReports() {
        return reportRepository.findAll().stream().
                map(r -> transform(r)).collect(Collectors.toList());
    }

    @Override
    public Report findReportById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<ReportDTO> findReportByIdAppointment(int id) {
        Appointment ap=appointmentService.findAppointmentById(id);
        return reportRepository.findByIdAppointment(ap).stream().map(r -> transform(r)).collect(Collectors.toList());
    }

    @Override
    public boolean removeReport(int id) {
        System.out.println(id);
        if(reportRepository.findById(id)!=null) {
            System.out.println("entra");
            reportRepository.deleteReportById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public Report transform(ReportDTO reportDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reportDTO, Report.class);
    }

    @Override
    public ReportDTO transform(Report report) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(report, ReportDTO.class);
    }
}
