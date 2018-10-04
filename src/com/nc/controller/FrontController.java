package com.nc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nc.model.Employee;
import com.nc.service.EmployeeService;

 
@WebServlet("*.html")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService;
	
	@Override
	public void init(ServletConfig config)throws ServletException{
		empService=new EmployeeService();
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String path= request.getRequestURL().toString();
		String query=request.getQueryString();
		String target="/WEB-INF/home.jsp";
	response.setContentType("text/html");
		response.getWriter().println("<h2>Path:"+path+"</h2>");
		response.getWriter().println("<h2>Query:"+query+"</h2>");
	
		if(path.endsWith("display.html")) {
			//go to home.jsp
			target="/WEB-INF/display.jsp";
		}else if (path.endsWith("register.html")) {
			//go to display.html
			target="/WEB-INF/register.jsp";
		}else if (path.endsWith("empSave.html")) {
			Employee newEmp= new Employee();
			newEmp.setName(request.getParameter("name"));
			newEmp.setUsername(request.getParameter("uname"));
			newEmp.setPassword(request.getParameter("password"));
			newEmp.setGender(request.getParameter("gender"));
			newEmp.setSalary(Long.parseLong(request.getParameter("salary")));
			
			String result=empService.addNewEmployee(newEmp);
			request.setAttribute("result", result);
			target="/WEB-INF/register.jsp";
		}else if (path.endsWith("validate.html")) {
			Employee emp=new Employee();
			emp.setUsername(request.getParameter("uname"));
			emp.setPassword(request.getParameter("upass"));
			if(empService.checkEmployee(emp)) {
				target="/WEB-INF/display.jsp";
			}
		else {
				String result="Login failed! please try again";
				request.setAttribute("result", result);
			}
		}	
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
