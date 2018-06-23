package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.UserBean;
import com.product.dao.CustomerDao;
import com.product.dao.UserDao;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String usertype = request.getParameter("type");
		
		UserBean ub = new UserBean();
		ub.setPwd(pass);
		ub.setUsername(name);
		ub.setUsertype(usertype);
		UserDao  udao = new UserDao();
		try {
			boolean flag = udao.add(ub);
			if(flag)
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				out.println("<script>alert('添加成功!')</script>");
				
			}
			else
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				
				out.println("<script>alert('添加失败!')</script>");
				response.setHeader("refresh", "0;url=user/user.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
		
	

	}

}
