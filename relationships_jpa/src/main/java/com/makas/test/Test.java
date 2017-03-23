package com.makas.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.makas.relationships_jpa.Car;
import com.makas.relationships_jpa.Person;
import com.makas.service.CarService;
public class Test {
     public static void main(String...args){
    	 
       // get an instance of CarService 	 
    	 CarService cs = new CarService();
    	 Car c1 = new Car();
    	    c1.setMade("Toyota");
    	    c1.setMillage(120000);
    	    
    	    
    	    
       // Create a list of 2 persons   	    
    	    Person p1 = new Person();
    	           p1.setAge(22);
    	           p1.setFirstName("Brahima");
    	           p1.setLastName("Traore");
    	           p1.setCars(null);
    	           
    	    Person p2 = new Person();
    	           p2.setAge(20);
	               p2.setFirstName("Maimouna");
	               p2.setLastName("Traore");
	               p2.setCars(null);
	    
	      List<Person>   plist = new ArrayList<Person>();
	                      plist.add(p1);
	                      plist.add(p2);
	      // add the list to the car 
	            c1.setPersons(plist);
	       //Synchronize 
	            List<Car> carList = new ArrayList<Car>();
	                      carList.add(c1);
	                      p1.setCars(carList);
	                      p2.setCars(carList);
	            
	            cs.createCar(c1);	       	    
	       	    Car c = cs.getCar(c1);
	       	    System.out.println(c.toString());
	       	           	    
	       // create a new person and add him to the car and add the car to him
	       	    Person p3 = new Person("Da","Komolo",new Date());
	       	    cs.addPersonToCar(cs.getCar(c1), p3);
	       	    p3.setCars(carList);
	       	    
	       //get the Car from the DB and print it
	       	    Car cr = cs.getCar(c1);
	       	    System.out.println(cr);
	       	    
	       	//verify that persons car is persisted;
	       	    for(Person p : cr.getPersons()){
	       	    	
	       	    	System.out.println(p.getPersonId()+ " : "+  p.getCars());
	       	    }
     }
    		 
    		 
}
