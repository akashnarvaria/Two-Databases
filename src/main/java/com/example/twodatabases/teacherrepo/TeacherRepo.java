package com.example.twodatabases.teacherrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twodatabases.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer>{

}
