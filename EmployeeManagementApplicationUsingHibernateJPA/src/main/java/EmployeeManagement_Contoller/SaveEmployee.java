package EmployeeManagement_Contoller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import EmployeeManagement_DTO.Employee;

public class SaveEmployee {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee e = new Employee();
		e.setFname("Jyosthna");
		e.setLname("Priya");
		e.setDateofbirth(LocalDate.of(2004, 9, 19));
		e.setDateofjoin(LocalDate.of(2023, 10, 8));
		e.setDesignation("Associative software developer");
		e.setSalary(45000);
		manager.persist(e);
		transaction.begin();
		transaction.commit();
		System.out.println("Saved Employee succesfully");
	}
}
