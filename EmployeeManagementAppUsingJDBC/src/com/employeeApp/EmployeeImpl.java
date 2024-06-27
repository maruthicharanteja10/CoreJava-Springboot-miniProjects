package com.employeeApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeImpl implements EmployeeInterface {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public void createEmployee(Employee emp) {
		String query = "insert into emp values(?,?,?,?,?)";
		try {
			con = DbConnection.createDBConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getName());
			pst.setDouble(3, emp.getSalary());
			pst.setInt(4, emp.getAge());
			pst.setString(5, emp.getDesg());
			pst.executeUpdate();
			System.out.println("Employee data inserted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DisplayAllEmployee() {
		String query = "select * from emp";
		System.out.println("Employee Details :");
		System.out.println("---------------------------------------------");
		try {
			con = DbConnection.createDBConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("Employeeid :" + rs.getInt(1) + "\nEmployeeName :" + rs.getString(2) + "\nSalary :"
						+ rs.getDouble(3) + " \nAge : " + rs.getInt(4) + "\nDesignation :" + rs.getString(5));
				System.out.println("--------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedOnID(int id) {
		String query = "select * from emp where id=?";
		try {
			con = DbConnection.createDBConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("EmpId :" + rs.getInt(1) + "\nEmpName :" + rs.getString(2) + "\nEmpSalary :"
						+ rs.getDouble(3) + "\nAge :" + rs.getInt(4) + "\nDesignation :" + rs.getString(5));
			} else {
				System.err.println("The specific id  is not present in the table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(int id, String name) {
		String query = "update emp set name=? where id=?";
		try {
			con = DbConnection.createDBConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, id);
			int r = pst.executeUpdate();
			if (r != 0) {
				System.out.println("Employee Details updated successfully !!");
			} else {
				System.err.println("The id or name is not present in the table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		String query = "delete from emp where id=?";
		try {
			con = DbConnection.createDBConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if (r != 0) {
				System.out.println(id + "Record of Employee table Deleted Successfully!!! ");
			} else {
				System.err.println("The record is not present in the table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
