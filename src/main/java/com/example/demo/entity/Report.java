package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Report {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "idAppointment")
    private Appointment idAppointment;

    private String data;
    private boolean resolution;

    public Report() {
        super();
    }

    public Report(int id, Appointment idAppointment, String data, boolean resolution) {
        this.id = id;
        this.idAppointment = idAppointment;
        this.data = data;
        this.resolution = resolution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Appointment idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isResolution() {
        return resolution;
    }

    public void setResolution(boolean resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", idAppointment=" + idAppointment +
                ", data='" + data + '\'' +
                ", resolution=" + resolution +
                '}';
    }
}
