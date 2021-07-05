package com.example.studentrank.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.istack.NotNull;

public class StudentModel {
	
	@NotNull
	private String name;
	@NotNull
	private int age;
	@NotNull
	private int marks[];
	
	
	public StudentModel() {
		super();
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

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public StudentModel(String name, int age, int[] marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	
	
	
	}
