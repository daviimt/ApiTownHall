package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ReportDTO {

	private int id;

	private String data;
	private boolean resolution;
	private int id_appointment;

	public ReportDTO() {
		super();
	}

	public ReportDTO(int id, String data, boolean resolution, int id_appointment) {
		super();
		this.id = id;
		this.data = data;
		this.resolution = resolution;
		this.id_appointment = id_appointment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getId_appointment() {
		return id_appointment;
	}

	public void setId_appointment(int id_appointment) {
		this.id_appointment = id_appointment;
	}

}
