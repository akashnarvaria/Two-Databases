package com.example.twodatabases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twodatabases.model.Teacher;
import com.example.twodatabases.teacherrepo.TeacherRepo;

@RestController
public class teacherController {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> getTeachers(){
		return ResponseEntity.ok(this.teacherRepo.findAll());
	}
}
