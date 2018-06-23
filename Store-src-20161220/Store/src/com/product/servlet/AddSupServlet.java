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
import com.product.bean.SupplierBean;
import com.product.dao.CustomerDao;
import com.product.dao.SupplierDao;
import com.product.dao.UserDao;

public class AddSupServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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

		String pcompany = request.getParameter("pcompany");
		String pconnector = request.getParameter("pconnector");
		String pemail = request.getParameter("pemail");
		String ptel = request.getParameter("ptel");
		String paddress = request.getParameter("paddress");
		String pcode = request.getParameter("pcode");
		String premark = request.getParameter("premark");

		SupplierBean pb = new SupplierBean();
		pb.setPaddress(paddress);
		pb.setPcode(pcode);
		pb.setPcompany(pcompany);
		pb.setPemail(pemail);
		pb.setPconnector(pconnector);
		pb.setPremark(premark);
		pb.setPtel(ptel);
		SupplierDao udao = new SupplierDao();
		try {
			boolean flag = udao.add(pb);
			if (flag) {

				SupplierDao ud = new SupplierDao();
				List list = ud.findAll("");
				request.setAttribute("plist", list);
				request.getRequestDispatcher("supplier/supplier.jsp").forward(
						request, response);
				out.println("<script>alert('添加成功!')</script>");

			} else {
				SupplierDao ud = new SupplierDao();
				List list = ud.findAll("");
				request.setAttribute("plist", list);
				request.getRequestDispatcher("supplier/supplier.jsp").forward(
						request, response);
				out.println("<script>alert('添加失败!')</script>");
				response.setHeader("refresh", "0;url=supplier/supplier.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}

}
