package com.nc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.nc.model.Employee;
public class EmployeeDao {

	public Employee addNewEmployee(Employee employee) {
		
		
		String sql="insert into employees values(?,?,?,?,?,?)";
		try (
		Connection conn= ConnectionUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql))
		{
		employee.setEmployeeId(getNextEmployeeId(conn));
		pst.setInt(1, employee.getEmployeeId());
		pst.setString(2, employee.getName());
		pst.setString(3, employee.getUsername());
		pst.setString(4, employee.getPassword());
		pst.setDouble(5, employee.getSalary());
		pst.setString(6, employee.getGender());
		
		pst.executeUpdate();	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return employee;
	}
	private Integer getNextEmployeeId(Connection conn) {
		Integer nextId=null;
		String sql="select max(empid) from employees";
		try {
		
		
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			nextId=rs.getInt(1)+1;
		}else {
			nextId=1;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nextId;	
	}
	
	public Boolean  validateEmployee(Employee employee)
	{
		String sql="select * from employees where username=? and password=?";
		Boolean result = false;
		try(Connection conn=ConnectionUtil.getConnection();
				PreparedStatement pst=conn.prepareStatement(sql))
		{
			pst.setString(1, employee.getUsername());
			pst.setString(2, employee.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
						result=true;
					}
					}
				catch(SQLException e)
		{
				e.printStackTrace();
		}
		
		return result;
	}
}
