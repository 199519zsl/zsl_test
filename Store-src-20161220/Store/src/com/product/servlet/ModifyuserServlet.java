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
import com.product.dao.UserDao;

public class ModifyuserServlet extends HttpServlet {

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
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		UserDao ud = new UserDao();
		UserBean ub=ud.searchById(id);
		request.setAttribute("user", ub);
		request.getRequestDispatcher("user/Modifyuser.jsp")
		               .forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String uid = request.getParameter("uid");
		int nid = Integer.parseInt(uid);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String usertype = request.getParameter("type");
		
		UserBean ub = new UserBean();
		ub.setId(nid);
		ub.setPwd(pass);
		ub.setUsername(name);
		ub.setUsertype(usertype);
		UserDao  udao = new UserDao();
		try {
			boolean flag = udao.update(ub);
			if(flag)
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				out.println("<script>alert('修改成功!')</script>");
				
			}
			else
			{
				UserDao ud = new UserDao();	
			    List list=ud.findAll("");
				request.setAttribute("cus", list);
				request.getRequestDispatcher("user/user.jsp")
				               .forward(request, response);
				out.println("<script>alert('修改失败!')</script>");
				response.setHeader("refresh", "0;url=user/user.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}

}
