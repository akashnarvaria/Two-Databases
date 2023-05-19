package com.example.twodatabases.studentrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twodatabases.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
