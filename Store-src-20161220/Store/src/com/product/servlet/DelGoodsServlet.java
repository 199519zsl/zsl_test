package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.GoodsDao;

public class DelGoodsServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		
		String goodsid = request.getParameter("id");
		int id = Integer.parseInt(goodsid);		
		   GoodsDao  gdao = new GoodsDao();		
			boolean flag = gdao.del(id);
			
			List list=gdao.query();
			request.setAttribute("glist", list);
			if(flag)
			{
				out.println("<script>alert('ɾ���ɹ�!')</script>");
				request.getRequestDispatcher("goods/goods.jsp")
	            .forward(request, response);
				
				
			}
			else
			{
				out.println("<script>alert('ɾ��ʧ��!')</script>");
				request.getRequestDispatcher("goods/goods.jsp")
	            .forward(request, response);
				
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
