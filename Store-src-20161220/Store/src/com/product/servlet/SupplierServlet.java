package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.SupplierDao;
import com.product.dao.UserDao;

public class SupplierServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		SupplierDao ud = new SupplierDao();	
	    List list=ud.findAll("");
		request.setAttribute("plist", list);
		request.getRequestDispatcher("supplier/supplier.jsp")
		               .forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pcomplany= request.getParameter("pcompany");
		SupplierDao ud = new SupplierDao();

	    List list=ud.findAll(pcomplany);
		
		request.setAttribute("plist", list);
		request.getRequestDispatcher("supplier/supplier.jsp")
		               .forward(request, response);
	}

}
