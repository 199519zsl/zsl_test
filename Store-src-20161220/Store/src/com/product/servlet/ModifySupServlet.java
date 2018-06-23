package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.product.bean.SupplierBean;

import com.product.dao.SupplierDao;

public class ModifySupServlet extends HttpServlet {

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
		SupplierDao ud = new SupplierDao();
		SupplierBean ub=ud.searchById(id);
		request.setAttribute("cus", ub);
		request.getRequestDispatcher("supplier/ModifySup.jsp")
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
		
		
		
		String sid = request.getParameter("pid");
		int cid = Integer.parseInt(sid);

		  String cucompany= request.getParameter("pcompany");
	      String cuname= request.getParameter("pconnector");
		 String cuemail= request.getParameter("pemail");
		 String cutel= request.getParameter("ptel");
		 String cuaddress= request.getParameter("paddress");
		 String cucode= request.getParameter("pcode");
		 String curemark= request.getParameter("premark");
		
		
		SupplierBean cb = new SupplierBean();
		cb.setPid(cid);
		cb.setPaddress(cuaddress);
		cb.setPcode(cucode);
		cb.setPcompany(cucompany);
		cb.setPemail(cuemail);
		cb.setPconnector(cuname);
		cb.setPremark(curemark);
		cb.setPtel(cutel);
		SupplierDao  udao = new SupplierDao();
		try {
			boolean flag = udao.update(cb);
			if(flag)
			{
				SupplierDao ud = new SupplierDao();	
			    List list=ud.findAll("");
				request.setAttribute("plist", list);
				request.getRequestDispatcher("supplier/supplier.jsp")
				               .forward(request, response);
				out.println("<script>alert('修改成功!')</script>");
				response.setHeader("refresh", "0;url=supplier/supplier.jsp");
			}
			else
			{
				SupplierDao ud = new SupplierDao();	
			    List list=ud.findAll("");
				request.setAttribute("plist", list);
				request.getRequestDispatcher("supplier/supplier.jsp")
				               .forward(request, response);
				out.println("<script>alert('修改失败!')</script>");
				response.setHeader("refresh", "0;url=supplier/supplier.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}

}
