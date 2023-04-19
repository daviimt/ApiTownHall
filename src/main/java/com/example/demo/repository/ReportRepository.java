package com.example.demo.repository;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("reportRepository")
public interface ReportRepository extends JpaRepository<Report, Serializable> {

    public abstract Report findById(int id);
    public abstract List<Report> findByIdAppointment(int id);
}
