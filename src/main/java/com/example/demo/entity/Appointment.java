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
	@JoinColumn(name = "id_user")
	private User id_user;

	@ManyToOne
	@JoinColumn(name = "id_manager")
	private User id_manager;

	@ManyToOne
	@JoinColumn(name = "id_department")
	private Department id_department;

	private String hour;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "id_appointment")
	private Report report;

	public Appointment() {
		super();
	}

	public Appointment(int id, User id_user, User id_manager, Department id_department, String hour, Date date) {
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

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public User getId_manager() {
		return id_manager;
	}

	public void setId_manager(User id_manager) {
		this.id_manager = id_manager;
	}

	public Department getId_department() {
		return id_department;
	}

	public void setId_department(Department id_department) {
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
		return "Appointment [id=" + id + ", id_user=" + id_user + ", id_manager=" + id_manager + ", id_department="
				+ id_department + ", hour=" + hour + ", date=" + date + "]";
	}

}
