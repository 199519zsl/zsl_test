package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.bean.UserBean;
import com.product.dao.CustomerDao;


public class CustomerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		CustomerDao ud = new CustomerDao();	
	    List list=ud.findAll("");
		request.setAttribute("culist", list);
		request.getRequestDispatcher("customer/customer.jsp")
		               .forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cucomplany= request.getParameter("cucompany");
        CustomerDao ud = new CustomerDao();

	    List list=ud.findAll(cucomplany);
		
		request.setAttribute("culist", list);
		request.getRequestDispatcher("customer/customer.jsp")
		               .forward(request, response);
		
	}

}
