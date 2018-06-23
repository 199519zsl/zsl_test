package com.product.unittest;

import java.sql.SQLException;
import java.util.List;

import com.product.bean.InhouseBean;
import com.product.bean.UserBean;
import com.product.dao.InhouseDao;
import com.product.dao.UserDao;

public class DaoTestadd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String name="123";
//		String password="123";
//		String code="123";
//		String utyper="123";
//		UserDao dao = new UserDao();
//		UserBean user = new UserBean();
//		user.setUsername(name);
//		user.setPwd(password);
//		user.setUsertype(utyper);
		
		InhouseDao  idao = new InhouseDao();
		List list = idao.queryAll("", "1");
		for (int i = 0; i < list.size(); i++) {
			InhouseBean b = (InhouseBean) list.get(i);
			System.out.println("user:"+ b.getOperatorname()+"---name"+b.getIname()+"size()="+ list.size());
		}
		
		
//		try {
//			dao.add(user);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}

}
