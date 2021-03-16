package com.cts.demo.application;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.model.Student;
import com.cts.demo.model.Subject;



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
	  	 Student student1=new Student();
		 System.out.println("Enter the student name");
		 student1.setName(scanner.next());
		 System.out.println("Enter the number of subjects");
		 int number=scanner.nextInt();
		 for(int i=0;i<number;i++)
		 {
			 System.out.println("Enter the subject name");
			 Subject subject=new Subject();
			 subject.setName(scanner.next());
			 student1.getSubjects().add(subject);
		 }
		 
		  session.persist(student1);
	  	 
          transaction.commit(); 
           session.close();
	}
	

}
