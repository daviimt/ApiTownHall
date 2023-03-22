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
	@JoinColumn(name = "id_appointment")
	private Appointment id_appointment;

	private String data;
	private boolean resolution;

	public Report() {
		super();
	}

	public Report(int id, Appointment id_appointment, String data, boolean resolution) {
		super();
		this.id = id;
		this.id_appointment = id_appointment;
		this.data = data;
		this.resolution = resolution;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Appointment getId_appointment() {
		return id_appointment;
	}

	public void setId_appointment(Appointment id_appointment) {
		this.id_appointment = id_appointment;
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
		return "Report [id=" + id + ", id_appointment=" + id_appointment + ", data=" + data + ", resolution="
				+ resolution + "]";
	}

}
