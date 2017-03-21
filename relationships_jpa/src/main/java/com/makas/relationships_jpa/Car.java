package com.makas.relationships_jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Car {
 @Id @GeneratedValue	
 private int carId;
 private String made ;
 private long millage;
 private List <Person> persons;
 
 
 
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
}
public String getMade() {
	return made;
}
public void setMade(String made) {
	this.made = made;
}
public long getMillage() {
	return millage;
}
public void setMillage(long millage) {
	this.millage = millage;
}
public List<Person> getPersons() {
	return persons;
}
public void setPersons(List<Person> persons) {
	this.persons = persons;
}
@Override
public String toString() {
	return "Car [carId=" + carId + ", made=" + made + ", millage=" + millage + ", persons=" + persons + "]";
}
 

 
}
