package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	@Id
	@GeneratedValue
	private int id;

	private String data;
	private boolean resolution;

	@OneToOne
	@JoinColumn(name = "idAppointment")
	private Appointment idAppointment;

}