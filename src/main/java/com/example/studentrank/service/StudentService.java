package com.example.studentrank.service;

import com.example.studentrank.dto.StudentDTO;

public interface StudentService {
	
	public StudentDTO addStudent(StudentDTO student);

	public StudentDTO findMaxMarks();

}
