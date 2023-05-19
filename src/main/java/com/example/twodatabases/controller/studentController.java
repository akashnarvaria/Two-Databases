package com.example.twodatabases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twodatabases.model.Student;
import com.example.twodatabases.studentrepo.StudentRepo;

@RestController
public class studentController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		return ResponseEntity.ok(this.studentRepo.findAll());
	}
}
