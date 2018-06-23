package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.CustomerDao;
import com.product.dao.UserDao;

public class UserServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		UserDao ud = new UserDao();	
	    List list=ud.findAll("");
		request.setAttribute("cus", list);
		request.getRequestDispatcher("user/user.jsp")
		               .forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cucomplany= request.getParameter("cucomplany");
		UserDao ud = new UserDao();

	    List list=ud.findAll(cucomplany);
		
		request.setAttribute("cus", list);
		request.getRequestDispatcher("user/user.jsp")
		               .forward(request, response);
	}

}
