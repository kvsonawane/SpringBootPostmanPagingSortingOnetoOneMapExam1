package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Applicant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String city;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id", referencedColumnName = "id")
	private Passport passport;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Passport getPassport()
	{
		return passport;
	}
	
	public void setPassport(Passport passport)
	{
		this.passport = passport;
	}

}
