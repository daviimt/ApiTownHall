package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User idUser;

	@ManyToOne
	@JoinColumn(name = "idManager")
	private User idManager;

	@ManyToOne
	@JoinColumn(name = "idDepartment")
	private Department idDepartment;

	private String hour;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idAppointment")
	private Report report;

	public Appointment() {
		super();
	}

	public Appointment(int id, User idUser, User idManager, Department idDepartment, String hour, Date date, Report report) {
		this.id = id;
		this.idUser = idUser;
		this.idManager = idManager;
		this.idDepartment = idDepartment;
		this.hour = hour;
		this.date = date;
		this.report = report;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public User getIdManager() {
		return idManager;
	}

	public void setIdManager(User idManager) {
		this.idManager = idManager;
	}

	public Department getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Department idDepartment) {
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

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", idUser=" + idUser +
				", idManager=" + idManager +
				", idDepartment=" + idDepartment +
				", hour='" + hour + '\'' +
				", date=" + date +
				", report=" + report +
				'}';
	}
}
