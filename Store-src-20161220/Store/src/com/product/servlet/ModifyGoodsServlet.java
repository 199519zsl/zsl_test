package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.GoodsBean;
import com.product.dao.CustomerDao;
import com.product.dao.GoodsDao;

public class ModifyGoodsServlet extends HttpServlet {

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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		GoodsDao gd = new GoodsDao();
		GoodsBean gb = gd.findById(id);
		request.setAttribute("goods", gb);

		request.getRequestDispatcher("goods/ModifyGoods.jsp").forward(request,
				response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String gname = request.getParameter("gname");
		String gnumber = request.getParameter("gnumber");
		String gprice = request.getParameter("gprice");
		String gsize = request.getParameter("gsize");
		String gmodel = request.getParameter("gmodel");
		String gbarcode = request.getParameter("gbarcode");
		String gclass = request.getParameter("gclass");
		String gremark = request.getParameter("gremark");
		String sid = request.getParameter("gid");
		int gid = Integer.parseInt(sid);
		
		
		GoodsBean ub = new GoodsBean();
        ub.setGid(gid);
		ub.setGname(gname);
		ub.setGnumber(Integer.parseInt(gnumber));
		ub.setGprice(Double.parseDouble(gprice));
		ub.setGsize(gsize);
		ub.setGmodel(gmodel);
		ub.setGbarcode(gbarcode);
		ub.setGclass(gclass);
		ub.setGremark(gremark);
		GoodsDao udao = new GoodsDao();		
		boolean flag = udao.update(ub);
		
	    List list=udao.query();
		request.setAttribute("glist", list);
		
		if (flag) {
			request.getRequestDispatcher("goods/goods.jsp")
            .forward(request, response);
			
			out.println("<script>alert('修改成功!')</script>");

		} else {
			request.getRequestDispatcher("goods/goods.jsp")
            .forward(request, response);
			out.println("<script>alert('修改失败!')</script>");
		}

	}

}
