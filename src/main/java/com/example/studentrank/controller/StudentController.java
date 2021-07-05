package com.example.studentrank.controller;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentrank.dto.StudentDTO;
import com.example.studentrank.model.StudentModel;
import com.example.studentrank.response.StudentResponse;
import com.example.studentrank.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	
	
	@PostMapping("/add")
	public StudentResponse addStudent( @RequestBody StudentModel model)
	{
		validateRequest(model);
		ModelMapper mapper = new ModelMapper();
		StudentDTO student = mapper.map(model, StudentDTO.class);
		StudentDTO savedUser = service.addStudent(student);
		return mapper.map(savedUser, StudentResponse.class);
		
	}

	@GetMapping("/findMax")
	public StudentResponse findMaxMarks()
	{
		ModelMapper mapper = new ModelMapper();
		StudentDTO student = service.findMaxMarks();
		return mapper.map(student, StudentResponse.class);
	
	}


	private void validateRequest(StudentModel model) {
		
		if(model.getAge()==0)
		{
			throw new RuntimeException("age cannot be zero");
		}
		if(model.getMarks()==null)
		{
			throw new RuntimeException("marks cannot be null");
		}
		if(model.getName()==null)
		{
			throw new RuntimeException("name is mandatory");
		}
		
	}

}
