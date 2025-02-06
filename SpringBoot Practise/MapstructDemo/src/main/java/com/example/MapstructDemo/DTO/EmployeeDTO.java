package com.example.MapstructDemo.DTO;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private int id;
	private String name;
	private int age;
	private String email;
	private int projId;
	private Date creationDate;

}
