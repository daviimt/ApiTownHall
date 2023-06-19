package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("reportRepository")
public interface ReportRepository extends JpaRepository<Report, Serializable> {

    public abstract Report findById(int id);

    @Query(value = "DELETE FROM report WHERE id = :id", nativeQuery = true)
    @Modifying
    public abstract void deleteReportById(@Param("id") int id);
    public abstract List<Report> findByIdAppointment(Appointment appointment);

}
