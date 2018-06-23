package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.CustomerDao;
import com.product.dao.GoodsDao;

public class GoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		GoodsDao gd = new GoodsDao();
		List list = gd.query();
		request.setAttribute("glist", list);
		request.getRequestDispatcher("goods/goods.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String gcomplany = request.getParameter("gcompany");
		GoodsDao ud = new GoodsDao();

		List list = ud.queryAll(gcomplany);

		request.setAttribute("glist", list);
		request.getRequestDispatcher("goods/goods.jsp").forward(request,
				response);

	}

}
