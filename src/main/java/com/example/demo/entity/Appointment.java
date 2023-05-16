package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idAppointment")
	private Report report;
}