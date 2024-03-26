package com.springboot.StudentManagementSystem.service;

import java.util.List;

import com.springboot.StudentManagementSystem.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student UpdateStudent(Student student);
	
	void  deleteStudentById(Long id);
}
