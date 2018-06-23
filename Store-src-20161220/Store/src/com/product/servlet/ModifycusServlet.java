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
import com.product.dao.CustomerDao;
import com.product.dao.UserDao;


public class ModifycusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		CustomerDao ud = new CustomerDao();
		CustomerBean ub=ud.searchById(id);
		request.setAttribute("cus", ub);
		request.getRequestDispatcher("customer/ModifyCus.jsp")
		               .forward(request, response);
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		String sid = request.getParameter("cuid");
		int cid = Integer.parseInt(sid);

		  String cucompany= request.getParameter("cucompany");
	      String cuconnector= request.getParameter("cuconnector");
		 String cuemail= request.getParameter("cuemail");
		 String cutel= request.getParameter("cutel");
		 String cuaddress= request.getParameter("cuaddress");
		 String cucode= request.getParameter("cucode");
		 String curemark= request.getParameter("curemark");
		
		
		CustomerBean cb = new CustomerBean();
		cb.setCuid(cid);
		cb.setCuaddress(cuaddress);
		cb.setCucode(cucode);
		cb.setCucompany(cucompany);
		cb.setCuemail(cuemail);
		cb.setCuconnector(cuconnector);
		cb.setCuremark(curemark);
		cb.setCutel(cutel);
		CustomerDao  udao = new CustomerDao();
		try {
			boolean flag = udao.update(cb);
			if(flag)
			{
				
				CustomerDao ud = new CustomerDao();	
			    List list=ud.findAll("");
				request.setAttribute("culist", list);
				request.getRequestDispatcher("customer/customer.jsp")
				               .forward(request, response);
				
				out.println("<script>alert('修改成功!')</script>");
				
			}
			else
			{
				CustomerDao ud = new CustomerDao();	
			    List list=ud.findAll("");
				request.setAttribute("culist", list);
				request.getRequestDispatcher("customer/customer.jsp")
				               .forward(request, response);
				out.println("<script>alert('修改失败!')</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}

}
