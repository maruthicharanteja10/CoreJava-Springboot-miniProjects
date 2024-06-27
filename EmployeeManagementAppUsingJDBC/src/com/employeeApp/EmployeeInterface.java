package com.employeeApp;

public interface EmployeeInterface {

	public void createEmployee(Employee emp);

	public void DisplayAllEmployee();

	public void showEmployeeBasedOnID(int id);

	public void updateEmployee(int id, String name);

	public void deleteEmployee(int id);
}
