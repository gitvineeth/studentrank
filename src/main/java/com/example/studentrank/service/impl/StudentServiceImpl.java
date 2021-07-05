package com.example.studentrank.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentrank.dto.StudentDTO;
import com.example.studentrank.entity.StudentEntity;
import com.example.studentrank.repository.StudentRepository;
import com.example.studentrank.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@Override
	public StudentDTO addStudent(StudentDTO student) {

		ModelMapper mapper = new ModelMapper();
		StudentEntity entity = mapper.map(student, StudentEntity.class);
		StudentEntity savedUser = repo.save(entity);
		return mapper.map(savedUser, StudentDTO.class);
		                        
	}

	@Override
	public StudentDTO findMaxMarks() {

		List<StudentEntity> stuList = repo.findAll();
		StudentEntity maxPerson = new StudentEntity();
		int maxScore = 0;
		int maxSum = 0;
		for (StudentEntity ent : stuList) {
			int sum = 0;
			
			for (int i = 0; i < ent.getMarks().length; i++) {

				sum = sum + ent.getMarks()[i];
			}
			
			if(sum>maxSum) {
				maxSum = sum;
			maxPerson = ent;
			}
		
		}

		ModelMapper mapper = new ModelMapper();
		return mapper.map(maxPerson, StudentDTO.class);
	}

}
