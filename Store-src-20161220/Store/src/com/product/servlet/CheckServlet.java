package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.bean.UserBean;
import com.product.dao.UserDao;
public class CheckServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		this.doPost(request, response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//接收用户名和密码
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String usertype = request.getParameter("type");
		
		
		UserBean ub = new UserBean();
		ub.setPwd(pass);
		ub.setUsername(name);
		ub.setUsertype(usertype);
		UserDao  udao = new UserDao();
		ub=udao.login(ub);
		//验证用户名和密码是否正确
		if(ub != null)
		{
			
//			response.sendRedirect("index.jsp");
			request.getSession().setAttribute("user",ub);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else
		{
			out.println("<script>alert('用户名或密码错误，请重新输入！');</script>");
			//延迟3秒再跳转
			response.setHeader("refresh", "0;url=login.jsp");
		}		
		out.flush();
		out.close();
	}

}
