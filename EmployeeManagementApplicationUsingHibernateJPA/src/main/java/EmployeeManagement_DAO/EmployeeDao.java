package EmployeeManagement_DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import EmployeeManagement_DTO.Employee;

public class EmployeeDao {
	static EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	Scanner s = new Scanner(System.in);

	public void save() {
		Employee e = new Employee();
		System.out.println("Enter frstname,LstName");
		e.setFname(s.next());
		e.setLname(s.next());
		System.out.println("year month date for date of birth");
		e.setDateofbirth(LocalDate.of(s.nextInt(), s.nextInt(), s.nextInt()));
		System.out.println("Year month date for date of join");
		e.setDateofjoin(LocalDate.of(s.nextInt(), s.nextInt(), s.nextInt()));
		System.out.println("Enter Email,Phone,Designation,password and Salary");
		e.setEmail(s.next());
		e.setPhone(s.nextLong());
		e.setDesignation(s.next());
		e.setPassword(s.next());
		e.setSalary(s.nextDouble());
		manager.persist(e);
		transaction.begin();
		transaction.commit();
		System.out.println("Saved Employee succesfully");

	}

	public void update() {
		Employee e = new Employee();
		System.out.println("Enter ID to Update");
		e.setId(s.nextInt());
		System.out.println("Enter frstname,LstName");
		e.setFname(s.next());
		e.setLname(s.next());
		System.out.println("year month date for date of birth");
		e.setDateofbirth(LocalDate.of(s.nextInt(), s.nextInt(), s.nextInt()));
		System.out.println("Year month date for date of join");
		e.setDateofjoin(LocalDate.of(s.nextInt(), s.nextInt(), s.nextInt()));
		System.out.println("Enter Email,Phone,Designation,password and Salary");
		e.setEmail(s.next());
		e.setPhone(s.nextLong());
		e.setDesignation(s.next());
		e.setPassword(s.next());
		e.setSalary(s.nextDouble());
		manager.merge(e);
		transaction.begin();
		transaction.commit();
		System.out.println("Updated Employee succesfully");
	}

	public void findById() {
		System.out.println("Enter ID to Find Employee details");
		int id = s.nextInt();
		Employee e = manager.find(Employee.class, id);
		if (e != null) {
			System.out.println("Name :" + e.getFname() + " " + e.getLname());
			System.out.println("Date of Birth :" + e.getDateofbirth());
			System.out.println("Email :" + e.getEmail());
			System.out.println("Phone :" + e.getPhone());
			System.out.println("Designation :" + e.getDesignation());
			System.out.println("Date of join :" + e.getDateofjoin());
			System.out.println("Salary :" + e.getSalary());
		} else {
			System.out.println("Employee is not found with these ID: " + e.getId());
		}
	}

	public void delete() {
		System.out.println("Enter ID to delete the Employee");
		int id = s.nextInt();
		Employee e = manager.find(Employee.class, id);
		if (e != null) {
			manager.remove(e);
			transaction.begin();
			transaction.commit();
			System.out.println("Deleted Employee succesfully");
		}
	}

	public void verifyById() {
		System.out.println("Enter ID and password to verify the Employee");
		int id = s.nextInt();
		String password = s.next();
		String qry = "select e from Employee e where e.id=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			Employee e = (Employee) q.getSingleResult();
			System.out.println("Employee is verified successfully");
			System.out.println("Name :" + e.getFname() + " " + e.getLname());
			System.out.println("Date of Birth :" + e.getDateofbirth());
			System.out.println("Email :" + e.getEmail());
			System.out.println("Phone :" + e.getPhone());
			System.out.println("Designation :" + e.getDesignation());
			System.out.println("Date of join :" + e.getDateofjoin());
			System.out.println("Salary :" + e.getSalary());
		} catch (NoResultException e) {
			System.out.println("Employee with ID and password is not verified ");
		}
	}

	public void verifyByPhone() {
		System.out.println("Enter  phonenumber and password to verify the Employee");
		long phone = s.nextLong();
		String password = s.next();
		String qry = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			Employee e = (Employee) q.getSingleResult();
			System.out.println("Employee is verified successfully");
			System.out.println("Name :" + e.getFname() + " " + e.getLname());
			System.out.println("Date of Birth :" + e.getDateofbirth());
			System.out.println("Email :" + e.getEmail());
			System.out.println("Phone :" + e.getPhone());
			System.out.println("Designation :" + e.getDesignation());
			System.out.println("Date of join :" + e.getDateofjoin());
			System.out.println("Salary :" + e.getSalary());
		} catch (NoResultException e) {
			System.out.println("Employee with phone and password is not verified ");
		}
	}

	public void verifyByEmail() {
		System.out.println("Enter  Email and password to verify the Employee");
		String email = s.next();
		String password = s.next();
		String qry = "select e from Employee e where e.email=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			Employee e = (Employee) q.getSingleResult();
			System.out.println("Employee is verified successfully");
			System.out.println("Name :" + e.getFname() + " " + e.getLname());
			System.out.println("Date of Birth :" + e.getDateofbirth());
			System.out.println("Email :" + e.getEmail());
			System.out.println("Phone :" + e.getPhone());
			System.out.println("Designation :" + e.getDesignation());
			System.out.println("Date of join :" + e.getDateofjoin());
			System.out.println("Salary :" + e.getSalary());
		} catch (NoResultException e) {
			System.out.println("Employee with email and password is not verified ");
		}
	}

	public void displayEmpwithafterDOJ() {
		String qry = "select e from Employee e where e.dateofjoin>='2023-01-01'";
		Query q = manager.createQuery(qry);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println("Employee is verified successfully");
				System.out.println("Name :" + e.getFname() + " " + e.getLname());
				System.out.println("Date of Birth :" + e.getDateofbirth());
				System.out.println("Email :" + e.getEmail());
				System.out.println("Phone :" + e.getPhone());
				System.out.println("Designation :" + e.getDesignation());
				System.out.println("Date of join :" + e.getDateofjoin());
				System.out.println("Salary :" + e.getSalary());
				System.out.println("---------------------------------");
			}
		} else {
			System.out.println("No Employee found  ");
		}

	}

	public void displayEmpWithsalary() {
		String qry = "select e from Employee e where e.salary>=35000";
		Query q = manager.createQuery(qry);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println("Employee is verified successfully");
				System.out.println("Name :" + e.getFname() + " " + e.getLname());
				System.out.println("Date of Birth :" + e.getDateofbirth());
				System.out.println("Email :" + e.getEmail());
				System.out.println("Phone :" + e.getPhone());
				System.out.println("Designation :" + e.getDesignation());
				System.out.println("Date of join :" + e.getDateofjoin());
				System.out.println("Salary :" + e.getSalary());
				System.out.println("---------------------------------");
			}
		} else {
			System.out.println("No Employee found  ");
		}

	}

	public void displayEmpWithDesgn() {
		String qry = "select e from Employee e where e.Designation in ('developer')";
		Query q = manager.createQuery(qry);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println("Employee is verified successfully");
				System.out.println("Name :" + e.getFname() + " " + e.getLname());
				System.out.println("Date of Birth :" + e.getDateofbirth());
				System.out.println("Email :" + e.getEmail());
				System.out.println("Phone :" + e.getPhone());
				System.out.println("Designation :" + e.getDesignation());
				System.out.println("Date of join :" + e.getDateofjoin());
				System.out.println("Salary :" + e.getSalary());
				System.out.println("---------------------------------");
			}
		} else {
			System.out.println("No Employee found  ");
		}

	}

}
