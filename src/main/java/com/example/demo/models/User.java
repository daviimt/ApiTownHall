package com.example.demo.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class User {

	private int id;
	private String username;
	private String password;
	private String name, surname, dni;
	private boolean enabled;
	private String role;
	private String token;
	private int idDepartment;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
	private List<AppointmentDTO> appointmentsList;
}