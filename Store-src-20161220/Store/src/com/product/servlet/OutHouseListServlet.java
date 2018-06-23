package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.UserBean;
import com.product.dao.GoodsDao;
import com.product.dao.InhouseDao;

public class OutHouseListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		InhouseDao indao = new InhouseDao();

		UserBean ub = (UserBean) request.getSession().getAttribute("user");

		List list = new ArrayList();
		
		if (ub.getUsertype().trim().equalsIgnoreCase("系统管理员")) {
			list = indao.query("ckd-");
		}else{
			list = indao.queryAll("", ub.getId() + "","ckd-");
		}
		
		request.setAttribute("outlist", list);
		request.getRequestDispatcher("outhouse/out.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String gcomplany = request.getParameter("gcompany");
		InhouseDao indao = new InhouseDao();

		UserBean ub = (UserBean) request.getSession().getAttribute("user");
		
		List list = new ArrayList();
		
		if (ub.getUsertype().trim().equalsIgnoreCase("系统管理员")) {
			list = indao.queryAll(gcomplany,"ckd-");
		}else{
			list = indao.queryAll(gcomplany, ub.getId() + "","ckd");
		}
		
		request.setAttribute("outlist", list);
		request.getRequestDispatcher("outhouse/out.jsp").forward(request,
				response);

	}

}
