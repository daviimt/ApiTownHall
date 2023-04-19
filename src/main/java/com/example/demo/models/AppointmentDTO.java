package com.example.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class AppointmentDTO {

	private int id;

	private int idUser;

	private int idManager;

	private int idDepartment;

	private String hour;
	private Date date;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int id, int idUser, int idManager, int idDepartment, String hour, Date date) {
		this.id = id;
		this.idUser = idUser;
		this.idManager = idManager;
		this.idDepartment = idDepartment;
		this.hour = hour;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AppointmentDTO{" +
				"id=" + id +
				", idUser=" + idUser +
				", idManager=" + idManager +
				", idDepartment=" + idDepartment +
				", hour='" + hour + '\'' +
				", date=" + date +
				'}';
	}
}
