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
	private int idAppointment;

	public ReportDTO() {
		super();
	}

	public ReportDTO(int id, String data, boolean resolution, int idAppointment) {
		this.id = id;
		this.data = data;
		this.resolution = resolution;
		this.idAppointment = idAppointment;
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

	public int getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}

	@Override
	public String toString() {
		return "ReportDTO{" +
				"id=" + id +
				", data='" + data + '\'' +
				", resolution=" + resolution +
				", idAppointment=" + idAppointment +
				'}';
	}
}
