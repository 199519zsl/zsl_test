package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.SystemBean;
import com.product.bean.UserBean;

public class SystemDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	/**
	 * 系统信息
	 */
	public List findAll()
	{
		     List list = new ArrayList(30);
    try{
			conn = new DatabaseUtil().getConn();
			String sql = "select * from systemconf";				
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				SystemBean ub = new SystemBean();
				ub.setId(rs.getInt("id"));
				ub.setParameter(rs.getString("parameter"));
				ub.setParemark(rs.getString("paremark"));
				ub.setPvalue(rs.getString("pvalue"));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
