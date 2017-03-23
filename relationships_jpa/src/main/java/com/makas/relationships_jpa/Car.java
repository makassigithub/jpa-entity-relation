package com.makas.relationships_jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
public class Car {
 @Id @GeneratedValue
 @Column(name="car_id")
 private int carId;
 
 @Column(name="brand", nullable = false)
 private String made ;
 
 @Column(name="kilometrage", nullable = false)
 private long millage;
 
 //Any time a Car is Persisted, Deleted, or Merged,the corresponding people 
 //should be affected
 //@ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
 @ManyToMany(cascade = {CascadeType.ALL})
 //Override the default join table and its columns
 //Also mean Car is the <Owner> of the relationship
 
 @JoinTable(name="CAR_OWNER",
	joinColumns={@JoinColumn(name="CAR_ID")},
	inverseJoinColumns={@JoinColumn(name="OWNER_ID")})
    private List <Person> persons;
 

	public Car() {	
	}
	
	public Car(String made,long millage){
		setMade(made);
		setMillage(millage);
	}
 
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
	return "Car [carId=" + carId + ", made=" + made + ", millage=" + millage +"]";
}
 

 
}
