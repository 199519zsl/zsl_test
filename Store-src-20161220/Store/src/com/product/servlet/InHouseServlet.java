package com.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.bean.GoodsBean;
import com.product.bean.InhouseBean;
import com.product.bean.UserBean;
import com.product.dao.GoodsDao;
import com.product.dao.InhouseDao;

public class InHouseServlet extends HttpServlet {

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

		String reqMethod = request.getParameter("method");
		List tempInlist = new ArrayList();

		if ("add".equalsIgnoreCase(reqMethod)) {

			String gid = request.getParameter("id");
			String paraname = "gcount_" + gid;
			String gcount = request.getParameter("gcount");

			GoodsDao ud = new GoodsDao();
			GoodsBean gb = ud.findById(Integer.parseInt(gid));
			gb.setGnumber(Integer.parseInt(gcount));

			tempInlist.add(gb);
			request.getSession().setAttribute("templist", tempInlist);

			String glist = request.getParameter("glist");
			request.getSession().setAttribute("glist", tempInlist);

		} else if ("modify".equalsIgnoreCase(reqMethod)) {
			String gid = request.getParameter("id");
			String paraname = "gtmpcount_" + gid;
			String gcount = request.getParameter(paraname);

			tempInlist = (List) request.getSession().getAttribute("templist");
			for (int i = 0; i < tempInlist.size(); i++) {
				GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
				if (tempGB.getGid() == Integer.parseInt(gid)) {
					tempGB.setGnumber(Integer.parseInt(gcount));
				}

			}
			request.getSession().setAttribute("templist", tempInlist);

		} else if ("del".equalsIgnoreCase(reqMethod)) {

			String gid = request.getParameter("id");
			String paraname = "gtmpcount_" + gid;
			String gcount = request.getParameter(paraname);

			tempInlist = (List) request.getSession().getAttribute("templist");
			for (int i = 0; i < tempInlist.size(); i++) {
				GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
				if (tempGB.getGid() == Integer.parseInt(gid)) {
					tempInlist.remove(i);
				}

			}

			request.getSession().setAttribute("templist", tempInlist);

		} else if ("conform".equalsIgnoreCase(reqMethod)) {

		}

		// ��ʾ��ѯ�����Ļ����б�������ӽ��� ����б�
		GoodsDao ud2 = new GoodsDao();
		List list = ud2.query();
		request.setAttribute("goodslist", list);

		// ҳ��չʾ�Ļ���������б�Ķ������޸�������ɾ�����������Ļ��

		// ������д�뵽���ݿ���������
		response.sendRedirect("inhouse/choosegoods.jsp");
//		request.getRequestDispatcher("inhouse/choosegoods.jsp").forward(
//				request, response);


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

		String reqMethod = request.getParameter("method");
		
		GoodsDao ud2 = new GoodsDao();
		List list = ud2.query();
		request.setAttribute("goodslist", list);

		String inlistcode = (String) request.getSession().getAttribute(
				"inlistcode");
		if (null == inlistcode) {
			SimpleDateFormat df2list = new SimpleDateFormat("yyyyMMdd-HHmmss");// �������ڸ�ʽ
			inlistcode = "rkd-" + df2list.format(new Date());
			request.getSession().setAttribute("inlistcode", inlistcode);
		}
		
		List tempInlist = (List) request.getSession().getAttribute(
		"templist");
		
		if(null==tempInlist){
			tempInlist = new ArrayList();
			request.getSession().setAttribute("templist", tempInlist);
		}
		

		if ("add".equalsIgnoreCase(reqMethod)) {

			String gid = request.getParameter("id");
			String paraname = "gcount_" + gid;
			String gcount = request.getParameter(paraname);

			GoodsDao ud = new GoodsDao();
			GoodsBean gb = ud.findById(Integer.parseInt(gid));
			gb.setGnumber(Integer.parseInt(gcount));

			tempInlist = (List) request.getSession().getAttribute(
					"templist");

			if (tempInlist == null) {
				tempInlist = new ArrayList();
				tempInlist.add(gb);
			} else {
				boolean isexist = false;
				for (int i = 0; i < tempInlist.size(); i++) {
					GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
					if (tempGB.getGid() == Integer.parseInt(gid)) {
						tempGB.setGnumber(Integer.parseInt(gcount));
						isexist = true;
					}

				}
				if (!isexist) {
					tempInlist.add(gb);
				}

			}


		} else if ("modify".equalsIgnoreCase(reqMethod)) {
			String gid = request.getParameter("id");
			String paraname = "gtmpcount_" + gid;
			String gcount = request.getParameter(paraname);

			tempInlist = (List) request.getSession().getAttribute(
					"templist");
			for (int i = 0; i < tempInlist.size(); i++) {
				GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
				if (tempGB.getGid() == Integer.parseInt(gid)) {
					tempGB.setGnumber(Integer.parseInt(gcount));
				}

			}
			request.getSession().setAttribute("templist", tempInlist);

		} else if ("del".equalsIgnoreCase(reqMethod)) {

			String gid = request.getParameter("id");

			tempInlist = (List) request.getSession().getAttribute(
					"templist");
			for (int i = 0; i < tempInlist.size(); i++) {
				GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
				if (tempGB.getGid() == Integer.parseInt(gid)) {
					tempInlist.remove(i);
				}

			}
			request.getSession().setAttribute("templist", tempInlist);
			

		} else if ("conform".equalsIgnoreCase(reqMethod)) {

			tempInlist = (List) request.getSession().getAttribute(
					"templist");

			UserBean userBean = (UserBean) request.getSession().getAttribute(
					"user");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
			String dtime = df.format(new Date());

			InhouseDao idao = new InhouseDao();
			for (int i = 0; i < tempInlist.size(); i++) {
				GoodsBean tempGB = (GoodsBean) tempInlist.get(i);
				InhouseBean ib = new InhouseBean();
				ib.setIname(tempGB.getGname());
				ib.setInumber(tempGB.getGnumber());
				ib.setIprice(tempGB.getGprice());
				ib.setIsize(tempGB.getGsize());
				ib.setImodel(tempGB.getGmodel());
				ib.setIbarcode(tempGB.getGbarcode());
				ib.setItime(dtime);
				ib.setOperatorname(userBean.getUsername());
				ib.setOperatorID(userBean.getId() + "");
				ib.setPcomplany(tempGB.getGcompany());
				ib.setPid(tempGB.getGid() + "");
				ib.setIncode(inlistcode);
				boolean flag = idao.add(ib);


			}
			
			

			request.getSession().setAttribute("templist", null);
			request.getSession().setAttribute("inlistcode", null);

		} else if ("query".equalsIgnoreCase(reqMethod)) {
			GoodsDao ud = new GoodsDao();
			String gname = request.getParameter("gcompany");
			list = ud.queryAll(gname);
			request.setAttribute("goodslist", list);

			tempInlist = (List) request.getSession().getAttribute(
					"templist");

			if (tempInlist == null) {
				tempInlist = new ArrayList();

			}
			request.getSession().setAttribute("templist", tempInlist);

		}
		request.getRequestDispatcher("inhouse/choosegoods.jsp").forward(
		request, response);
	}
}
