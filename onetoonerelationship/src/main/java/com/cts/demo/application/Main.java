package com.cts.demo.application;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.model.Address;
import com.cts.demo.model.Employee;

public class Main {

	public static void main(String[] args) {
		 // TODO Ao-generated method stub

Configuration configuration = new Configuration(); 
// Is keeping the info relate to the hibernate configuration
		
		configuration.configure("hibernate.cfg.xml");
// It is receiving the configuration information from hibernate.cfg.xml
		
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 Scanner scanner=new Scanner(System.in);
		 Session session=sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
	  	   Employee employee=new Employee();
	  	   System.out.println("Enter the name ");
	  	   employee.setFirstName(scanner.next());
	  	   
	       Address address=new Address();
	       System.out.println("Enter the street");
	       address.setStreet(scanner.next());
	       System.out.println("Enter the street");
	       
	       address.setCity(scanner.next());
	       session.save(address);
	       employee.setAddress(address);
	       session.save(employee); 
	       List<Employee>  employeeList=(List<Employee>)session.createQuery("from Employee").list();
	       for(Employee emp: employeeList)
	       {
	    	   System.out.print(emp.getFirstName()+"\t");
	    	   Address addr=emp.getAddress();
	    	   System.out.println(addr.getStreet()+"\t"+addr.getCity());
	       }
	       
          transaction.commit(); 
           session.close();
	}
	

}
