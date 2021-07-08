package com.training.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty @Size(min = 2 , message = "First Name Should  Have Atlest 2 Characters")
	@Column(name = "firstname")
	private String firstName;
	
	@NotEmpty @Size(min = 2 , message = "Last Name Should  Have Atlest 2 Characters")
	@Column(name = "lastname")
	private String lastName;
	
	@NotEmpty @Email( message = "Email is a required field")
	@Column(name = "email")
	private String email;
	
	
	public Customer(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Customer() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return String.format("Customer [id=%s, firstName=%s, lastName=%s, email=%s]", id, firstName, lastName, email);
	}
	
	
	

}
