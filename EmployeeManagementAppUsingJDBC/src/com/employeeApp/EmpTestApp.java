package com.employeeApp;

import java.util.Scanner;

public class EmpTestApp {
	public static void main(String[] args) {
		String name;
		int id = 0;
		
		EmployeeInterface dao = new EmployeeImpl();
		System.out.println("Welcome to Employee management application");

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("---------menu-----------");
			System.out.println("1. Add Employee\n" + "2. Show All Employee\n" + "3. Show Employee based on id \n"
					+ "4. Update the employee\n" + "5. Delete the employee\n");

			System.out.println("Enter Choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter ID : ");
				id = sc.nextInt();
				System.out.println("Enter name ");
				name = sc.next();
				System.out.println("Enter Salary ");
				double salary1 = sc.nextDouble();
				System.out.println("Enter age");
				int age1 = sc.nextInt();
				System.out.println("Enter Designation ");
				String desg1=sc.next();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary1);
				emp.setAge(age1);
				emp.setDesg(desg1);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.DisplayAllEmployee();
				break;
			case 3:
				System.out.println("Enter id to show the details ");
				int empid = sc.nextInt();
				dao.showEmployeeBasedOnID(empid);
				break;
			case 4:
				System.out.println("Enter id to update the details");
				int empid1 = sc.nextInt();
				System.out.println("Enter the new name");
				name = sc.next();
				dao.updateEmployee(empid1, name);
				break;
			case 5:
				System.out.println("Enter the id to delete");
				id = sc.nextInt();
				dao.deleteEmployee(id);
				break;
			case 6:
				System.out.println("Thank you for using our Application !!!");
				System.exit(0);
			default:
				System.out.println("Enter valid choice !");
				break;
			}

		} while (true);

	}
}
