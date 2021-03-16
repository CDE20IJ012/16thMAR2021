package com.cts.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="student_roll")
	private int roll;
	private String name;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_subject",joinColumns= {@JoinColumn(name="student_roll")},
	inverseJoinColumns= {@JoinColumn(name="subject_id")})
	private List<Subject> subjects=new ArrayList<Subject>();


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int roll, String name, List<Subject> subjects) {
		super();
		this.roll = roll;
		this.name = name;
		this.subjects = subjects;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roll;
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roll != other.roll)
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
     
	
}
