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

	private int id_user;

	private int id_manager;

	private int id_department;

	private String hour;
	private Date date;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int id, int id_user, int id_manager, int id_department, String hour, Date date) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_manager = id_manager;
		this.id_department = id_department;
		this.hour = hour;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_manager() {
		return id_manager;
	}

	public void setId_manager(int id_manager) {
		this.id_manager = id_manager;
	}

	public int getId_department() {
		return id_department;
	}

	public void setId_department(int id_department) {
		this.id_department = id_department;
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
		return "AppointmentDTO [id=" + id + ", id_user=" + id_user + ", id_manager=" + id_manager + ", id_department="
				+ id_department + ", hour=" + hour + ", date=" + date + "]";
	}

}
