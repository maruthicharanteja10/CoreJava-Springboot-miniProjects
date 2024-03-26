package com.springboot.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.StudentManagementSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	// No need to add @Repository
	// because by default JpaRepository has simpleJpaRepository with @Repository
	// Default it contains @Transactional methods
	
	
}
