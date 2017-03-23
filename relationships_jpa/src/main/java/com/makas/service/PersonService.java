package com.makas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.makas.relationships_jpa.Car;
import com.makas.relationships_jpa.Person;

public class PersonService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("relation_unit");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction tx = em.getTransaction();
	
	

	public Person createCar(Person p) {
		tx.begin();
		em.persist(p);
		tx.commit();
		return p;
	}
  
	public Person getPerson(Person p) {
		em.merge(p);
		return p;
	}

	public List<Car> getPersonCars(Person p) {
		tx.begin();
		em.merge(p);
		List<Car> car = p.getCars();
		return car;
	}
}
