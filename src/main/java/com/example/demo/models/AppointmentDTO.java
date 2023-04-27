package com.example.demo.models;

import java.util.Date;
import lombok.Data;

@Data
public class AppointmentDTO {

	private int id;

	private int idUser;

	private int idManager;

	private int idDepartment;

	private String hour;
	private Date date;
}