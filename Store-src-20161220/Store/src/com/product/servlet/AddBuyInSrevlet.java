package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.GoodsBean;
import com.product.bean.InhouseBean;
import com.product.dao.GoodsDao;
import com.product.dao.InhouseDao;

public class AddBuyInSrevlet extends HttpServlet {

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
		
		 String iname= request.getParameter("iname");
		 String inumber	= request.getParameter("inumber");
		 String iprice=request.getParameter("iprice");
		 String isize= request.getParameter("isize");
		 String imodel= request.getParameter("imodel");
		 String ibarcode= request.getParameter("ibarcode");
		 String itime= request.getParameter("itime");
		 String username= request.getParameter("username");
		 String pcomplany= request.getParameter("pcomplany");
				
		
		InhouseBean ub = new InhouseBean();
		ub.setIname(iname);
		ub.setInumber(Integer.parseInt(inumber));
		ub.setIprice(Double.parseDouble(iprice));
		ub.setIsize(isize);
		ub.setImodel(imodel);
		ub.setIbarcode(ibarcode);
		ub.setItime(itime);
//		ub.setUsername(username);
		ub.setPcomplany(pcomplany);
		InhouseDao  udao = new InhouseDao();
		boolean flag = udao.add(ub);
		if(flag)
		{
			out.println("<script>alert('添加成功!')</script>");
			response.setHeader("refresh", "0;url=inhouse/buyin.jsp");
		}
		else
		{
			out.println("<script>alert('添加失败!')</script>");
		response.setHeader("refresh", "0;url=inhouse/buyin.jsp");
		}
		
	}

	}


