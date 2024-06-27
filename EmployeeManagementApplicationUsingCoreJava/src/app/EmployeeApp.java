package app;

import java.util.Scanner;
import service.EmployeeService;
import serviceimpl.EmployeeServiceImpl;

public class EmployeeApp {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		EmployeeService e = new EmployeeServiceImpl();// UpCasting-->Abstraction
		System.out.println("----------Employee DataBase------------");
		while (true) {
			System.out.println("------Menu--------");
			System.out.println("1.AddEmployee\n2.Get Employee by Eid\n3.Update Employee By Eid\n4.Get Employee by sal");
			System.out.println("5.Remove Employee By Eid\n6.All Employee Details\n7.Exit");
			System.out.println("Enter the Option:-");
			int op = ip.nextInt();
			switch (op) {
			case 1:
				e.addEmplyee();
				break;
			case 2:
				e.getEmpByEid();
				break;
			case 3:
				e.updateEmpByEid();
				break;
			case 4:
				e.getEmpBySal();
				break;

			case 5:
				e.removeEmpByEid();
				break;
			case 6:
				e.allDetails();
				break;

			case 7:
				System.out.println("Thank you.....Visit Again...!!");
				System.exit(0);
			default:
				System.out.println("Oops....Invalid Option...!");
			}
		}
	}
}
