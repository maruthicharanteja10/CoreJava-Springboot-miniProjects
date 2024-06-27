package serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import Entity.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> l1 = new ArrayList<Employee>();
	Scanner ip = new Scanner(System.in);

	@Override
	public void addEmplyee() {
		System.out.println("-----Enter Employee Details-----");
		System.out.println("Enter the Employee name");
		String ename = ip.next();
		System.out.println("Enter the Employee id");
		int eid = ip.nextInt();
		System.out.println("Enter the Phoneno");
		long ephno = ip.nextLong();
		System.out.println("Enter the emp salary");
		double esal = ip.nextDouble();
		System.out.println("Enter the emp Age");
		int eage = ip.nextInt();
		System.out.println("Enter the Emp Designation");
		String edesgn = ip.next();
		l1.add(new Employee(ename, eid, ephno, esal, eage, edesgn));
	}

	@Override
	public void getEmpByEid() {
		System.out.println("Enter the Eid");
		boolean flag = false;
		int eid = ip.nextInt();
		System.out.println("Searching Employee by Eid");
		for (Employee ele : l1) {
			if (ele.getEid() == eid) {
				System.out.println(ele);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.err.println("Employee Not Found");
		}
	}

	@Override
	public void getEmpBySal() {
		System.out.println("Enter the salary");
		boolean flag = false;
		double esal = ip.nextDouble();
		System.out.println("Searching Employee by Salary");
		for (Employee ele : l1) {
			if (ele.getEsal() == esal) {
				System.out.println(ele);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.err.println("Employee Not Found");
		}
	}

	@Override
	public void updateEmpByEid() {

		System.out.println("Enter the empId:-");
		boolean flag = false;
		int eid = ip.nextInt();
		System.out.println("Updating employee by eid");
		for (Employee ele : l1) {

			if (ele.getEid() == eid) {
				flag = true;
				System.out.println("------Attributes-----");
				System.out.println("1.Name\n2.Salary\n3.Age\n4.Designation\n5.Phno");
				System.out.println("Enter your option:-");
				int op = ip.nextInt();
				switch (op) {
				case 1:
					System.out.println("Enter the new name");
					String name = ip.next();
					ele.setName(name);
					break;
				case 2:
					System.out.println("Enter the new salary");
					double sal = ip.nextDouble();
					ele.setEsal(sal);
					break;
				case 3:
					System.out.println("Enter the new name");
					int age = ip.nextInt();
					ele.setAge(age);
					break;
				case 4:
					System.out.println("Enter the new name");
					String desgn = ip.next();
					ele.setEdesgn(desgn);
					break;
				case 5:
					System.out.println("Enter the new name");
					Long phno = ip.nextLong();
					ele.setPhoneno(phno);
					break;
				default:
					System.out.println("Invalid option...!!");
				}
			}
		}
		if (flag == false) {
			System.out.println("Employee not found....!");
		}
	}

	@Override
	public void removeEmpByEid() {
		System.out.println("Enter to eid to remove:-");
		int eid = ip.nextInt();
		boolean flag = false;
		for (int i = 0; i < l1.size(); i++) {
			Employee e = l1.get(i);
			if (e.getEid() == eid) {
				System.out.println("Employee is removed Successfully");
				l1.remove(i);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Employee is not found..!!");
		}
	}

	@Override
	public void allDetails() {
		System.out.println("------Employees Details------");
		if (l1.size() == 0) {
			System.out.println("Database is empty...!1");
		} else {
			for (Employee ele : l1) {
				System.out.println(ele);
			}
		}

	}

}
