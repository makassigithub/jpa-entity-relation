package com.makas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.makas.relationships_jpa.*;

public class CarService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("relation_unit");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction tx = em.getTransaction();

	public Car createCar(Car car) {
		tx.begin();
		em.persist(car);

		// Without @Cascade annotation on the entities, we would have hard coded Person's persistence.
		for (Person p : car.getPersons()) {
			em.persist(p);
		}
		em.flush();// optional
		tx.commit();
		return car;
	}

	public Car getCar(Car car) {
		em.merge(car);
		return car;
	}

	public List<Person> getCarUsers(Car car) {

		tx.begin();
		em.merge(car);
		List<Person> ps = car.getPersons();

		return ps;
	}

}
