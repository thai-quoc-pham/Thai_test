package com.myC.thymeleaf.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "contact")
public class contact {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)	
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phonenumber", nullable = true)
	private String phonenumber;

	public contact() {
	}


	public contact(int id, String name, String phonenumber) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
}
