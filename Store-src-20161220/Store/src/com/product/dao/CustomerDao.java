package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.CustomerBean;
import com.product.bean.UserBean;

public class CustomerDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	public boolean add(CustomerBean cus) throws SQLException {//添加客户信息
		String sql = "insert into customer(cuname,cuconnector,cutel,cuemail,cuaddress,cucode,curemark) values(?,?,?,?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,cus.getCucompany());
			ps.setString(2,cus.getCuconnector());
			ps.setString(3,cus.getCutel());
			ps.setString(4,cus.getCuemail());
			ps.setString(5,cus.getCuaddress());
			ps.setString(6,cus.getCucode());
			ps.setString(7,cus.getCuremark());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	/**
	 * 查询所有的客户信息
	 */
	public List findAll(String cucomplany )
	{
		
		List list = new ArrayList(30);
		
		try {
			conn = new DatabaseUtil().getConn();
				if( cucomplany !="")
				{
					String sql = "select * from customer where cuname like ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%"+cucomplany+"%" );
					
				}
				else
				{
					String sql = "select * from customer";
					ps = conn.prepareStatement(sql);
					
				}
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				CustomerBean cus=new CustomerBean();
				cus.setCuaddress(rs.getString("cuaddress"));
				cus.setCucode(rs.getString("cucode"));
				cus.setCucompany(rs.getString("cuname"));
				cus.setCuemail(rs.getString("cuemail"));
				cus.setCuid(rs.getInt("cuid"));
				cus.setCuconnector(rs.getString("cuconnector"));
				cus.setCuremark(rs.getString("curemark"));
			    cus.setCutel(rs.getString("cutel"));
				list.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(CustomerBean  u) throws SQLException {//修改客户信息

		String sql = "update customer set cuaddress=?,cucode=?,cuname=?,cuemail=?,cuconnector=?,curemark=?,cutel=?where cuid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getCuaddress());
			ps.setString(2, u.getCucode());
			ps.setString(3, u.getCucompany());
			ps.setString(4, u.getCuemail());
			ps.setString(5, u.getCuconnector());
			ps.setString(6, u.getCuremark());
			ps.setString(7, u.getCutel());
			ps.setInt(8, u.getCuid());
		
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean del(int id)  {//删除顾客信息
		String sql = "delete from customer where cuid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}
	public CustomerBean searchById(int id)//根据用户ID查询客户
	{
		
		
		String sql = "select * from customer where cuid=?";
		try {
			CustomerBean cus=new CustomerBean();
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				cus.setCuaddress(rs.getString("cuaddress"));
				cus.setCucode(rs.getString("cucode"));
				cus.setCucompany(rs.getString("cuname"));
				cus.setCuemail(rs.getString("cuemail"));
				cus.setCuid(rs.getInt("cuid"));
				cus.setCuconnector(rs.getString("cuconnector"));
				cus.setCuremark(rs.getString("curemark"));
			    cus.setCutel(rs.getString("cutel"));
				return cus;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
