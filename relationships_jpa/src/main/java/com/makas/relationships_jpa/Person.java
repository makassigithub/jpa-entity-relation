package com.makas.relationships_jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
public class Person {
	
	@Id @GeneratedValue
	private int personId;
	
	@Column(name="Prenom")
	private String firstName;
	
	@Column(name="Nom")
	private String LastName;
	
	@Transient
	private int age;
	
	@Temporal(TemporalType.DATE)
	private Date date_of_birth;
	
	@ManyToMany(targetEntity=Car.class, mappedBy="persons")
	private List<Car> cars;
	
	
	
	public Person() {
	}


	public Person(String firstName, String lastName,Date date_of_birth) {
		
		setFirstName(firstName);
		LastName = lastName;
		setDate_of_birth(date_of_birth);
	}
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public List<Car> getCars() {
		return cars;
	}
	
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", LastName=" + LastName + ", age=" + age
				+ "]";
	}
	
	

}
