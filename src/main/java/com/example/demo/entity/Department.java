package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "someOtherProperty"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartment")
	private List<Appointment> appointmentsList;
}