package com.nc.service;

import com.nc.dao.EmployeeDao;
import com.nc.model.Employee;

public class EmployeeService {
private EmployeeDao employeeDao;
public EmployeeService()
{
	employeeDao=new EmployeeDao();
	}
public String addNewEmployee(Employee employee)
{
	String message=" ";
	employee=employeeDao.addNewEmployee(employee);
	if(employee.getEmployeeId()!=null)
	{
		message="New Employee Registration Success! Your ID is "+employee.getEmployeeId();
	}
	else
	{
		message="Problem!";
	} 
	return message;
	}
public Boolean checkEmployee(Employee employee)
{
	return employeeDao.validateEmployee(employee);
	}

}