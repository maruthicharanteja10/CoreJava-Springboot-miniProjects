package EmployeeManagement_Contoller;

import java.util.Scanner;
import EmployeeManagement_DAO.EmployeeDao;

public class EmployeeManagementController {
	static EmployeeDao e = new EmployeeDao();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Delete Employee Account By Id");
		System.out.println("5.verify Employee Account By Id and password");
		System.out.println("6.verify Employee Account By phone and password");
		System.out.println("7.verify Employee Account By email and password");
		System.out.println("8.Display details of Employees whose date-of-join after 2023");
		System.out.println("9.Display details of Employees salary greater than 35000");
		System.out.println("10.Display details of Employees whose designation is developer");
		System.out.println("--------------------------------------");
		System.out.println("Enter the choice ");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			e.save();
			break;
		}
		case 2: {
			e.update();
			break;
		}
		case 3: {
			e.findById();
			break;
		}
		case 4: {
			e.delete();
			break;
		}
		case 5: {
			e.verifyById();
			break;
		}
		case 6: {
			e.verifyByPhone();
			break;
		}
		case 7: {
			e.verifyByEmail();
			break;
		}
		case 8: {
			e.displayEmpwithafterDOJ();
			break;
		}
		case 9: {
			e.displayEmpWithsalary();
			break;
		}
		case 10: {
			e.displayEmpWithDesgn();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}

		}
	}
}
