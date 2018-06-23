package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.bean.UserBean;
import com.product.dao.CustomerDao;
import com.product.dao.UserDao;

public class deleteUserServlet extends HttpServlet {

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

		HttpSession session=request.getSession();
		UserBean ub=(UserBean)session.getAttribute("user");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);		
		if(id==ub.getId())
		{
			UserDao ud = new UserDao();	
		    List list=ud.findAll("");
			request.setAttribute("cus", list);
			request.getRequestDispatcher("user/user.jsp")
			               .forward(request, response);
			out.println("<script>alert('当前登录用户不能删除!')</script>");
			response.setHeader("refresh", "0;url=user/user.jsp");
			
		}else
		{
		
		   UserDao  udao = new UserDao();
		
			boolean flag = udao.del(id);
			if(flag)
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				out.println("<script>alert('删除成功!')</script>");
				
				
			}
			else
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				out.println("<script>alert('删除失败!')</script>");
				
			}
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
