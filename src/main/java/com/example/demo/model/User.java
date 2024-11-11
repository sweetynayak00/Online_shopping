package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String conform_password;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(String name, String email, String password, String conform_password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.conform_password = conform_password;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConform_password() {
		return conform_password;
	}
	public void setConform_password(String conform_password) {
		this.conform_password = conform_password;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", conform_password=" + conform_password + "]";
	}
	
	
}
