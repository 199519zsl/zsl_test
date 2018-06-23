package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.CustomerBean;
import com.product.bean.UserBean;
import com.product.dao.CustomerDao;
import com.product.dao.UserDao;

public class AddCusServlet extends HttpServlet {

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

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	
		  String cucomplany= request.getParameter("cucompany");
	      String cuconnector= request.getParameter("cuconnector");
		 String cuemail= request.getParameter("cuemail");
		 String cutel= request.getParameter("cutel");
		 String cuaddress= request.getParameter("cuaddress");
		 String cucode= request.getParameter("cucode");
		 String curemark= request.getParameter("curemark");
		
		
		CustomerBean cb = new CustomerBean();
		cb.setCuaddress(cuaddress);
		cb.setCucode(cucode);
		cb.setCucompany(cucomplany);
		cb.setCuemail(cuemail);
		cb.setCuconnector(cuconnector);
		cb.setCuremark(curemark);
		cb.setCutel(cutel);
		CustomerDao  udao = new CustomerDao();
		try {
			boolean flag = udao.add(cb);
			if(flag)
			{
				CustomerDao ud = new CustomerDao();	
			    List list=ud.findAll("");
				request.setAttribute("culist", list);
				request.getRequestDispatcher("customer/customer.jsp")
				               .forward(request, response);
				out.println("<script>alert('添加成功!')</script>");
				response.setHeader("refresh", "0;url=customer/customer.jsp");
			}
			else
			{
				CustomerDao ud = new CustomerDao();	
			    List list=ud.findAll("");
				request.setAttribute("culist", list);
				request.getRequestDispatcher("customer/customer.jsp")
				               .forward(request, response);
				out.println("<script>alert('添加失败!')</script>");
				response.setHeader("refresh", "0;url=customer/customer.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}
}
