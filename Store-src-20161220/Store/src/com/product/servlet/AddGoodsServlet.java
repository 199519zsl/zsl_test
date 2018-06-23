package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.GoodsBean;
import com.product.bean.UserBean;
import com.product.dao.GoodsDao;
import com.product.dao.UserDao;

public class AddGoodsServlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
		 String gname= request.getParameter("gname");
		 String gnumber	= request.getParameter("gnumber");
		 String gprice=request.getParameter("gprice");
		 String gsize= request.getParameter("gsize");
		 String gmodel= request.getParameter("gmodel");
		 String gbarcode= request.getParameter("gbarcode");
		 String gclass= request.getParameter("gclass");
		 String gremark= request.getParameter("gremark");
		
		
		
		GoodsBean ub = new GoodsBean();
		ub.setGname(gname);
		ub.setGnumber(Integer.parseInt(gnumber));
		ub.setGprice(Double.parseDouble(gprice));
		ub.setGsize(gsize);
		ub.setGmodel(gmodel);
		ub.setGbarcode(gbarcode);
		ub.setGclass(gclass);
		ub.setGremark(gremark);
		GoodsDao  gdao = new GoodsDao();
		boolean flag = gdao.add(ub);
		
		List list=gdao.query();
		request.setAttribute("glist", list);
		
		if(flag)
		{
			
			out.println("<script>alert('添加成功!')</script>");
			request.getRequestDispatcher("goods/goods.jsp")
            .forward(request, response);
			
			response.setHeader("refresh", "0;url=goods/goods.jsp");
		}
		else
		{
			
			out.println("<script>alert('添加失败!')</script>");
			request.getRequestDispatcher("goods/goods.jsp")
            .forward(request, response);
		response.setHeader("refresh", "0;url=goods/goods.jsp");
		}
		
	}

}
