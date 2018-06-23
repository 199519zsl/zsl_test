package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.product.bean.SupplierBean;


public class SupplierDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	public boolean add(SupplierBean pb) throws SQLException {//添加客户信息
		String sql = "insert into provider(pconnector,pemail,ptel,premark,paddress,pcode,pcompany) values(?,?,?,?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,pb.getPconnector());
			ps.setString(2,pb.getPemail());
			ps.setString(3,pb.getPtel());
			ps.setString(4,pb.getPremark());
			ps.setString(5,pb.getPaddress());
			ps.setString(6,pb.getPcode());
			ps.setString(7,pb.getPcompany());
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
	public List findAll(String pcompany)
	{
		List list = new ArrayList(30);
	
		try {
			
			conn = new DatabaseUtil().getConn();
			if( pcompany !="")
			{
				String sql = "select * from provider where pcompany like ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+ pcompany+"%" );
				
			}
			else
			{
				String sql = "select * from provider";
				ps = conn.prepareStatement(sql);
				
			}
			
			
		
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				SupplierBean cus=new SupplierBean();
				cus.setPaddress(rs.getString("paddress"));
				cus.setPcode(rs.getString("pcode"));
				cus.setPemail(rs.getString("pemail"));
				cus.setPid(rs.getInt("pid"));
				cus.setPconnector(rs.getString("pconnector"));
				cus.setPremark(rs.getString("premark"));
			    cus.setPtel(rs.getString("ptel"));
			    cus.setPcompany(rs.getString("pcompany"));
				list.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(SupplierBean  u) throws SQLException {//修改客户信息

		String sql = "update provider set paddress=?,pcode=?,pemail=?,pconnector=?,premark=?,ptel=?where pid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPaddress());
			ps.setString(2, u.getPcode());
			ps.setString(3, u.getPemail());
			ps.setString(4, u.getPconnector());
			ps.setString(5, u.getPremark());
			ps.setString(6, u.getPtel());
			ps.setInt(7, u.getPid());
		
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
		String sql = "delete from provider where pid=?";
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
	public SupplierBean searchById(int id)//根据用户ID查询客户
	{
		
		
		String sql = "select * from provider where pid=?";
		try {
			SupplierBean cus=new SupplierBean();
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				cus.setPaddress(rs.getString("paddress"));
				cus.setPcode(rs.getString("pcode"));
				cus.setPemail(rs.getString("pemail"));
				cus.setPid(rs.getInt("pid"));
				cus.setPconnector(rs.getString("pconnector"));
				cus.setPremark(rs.getString("premark"));
			    cus.setPtel(rs.getString("ptel"));
			    cus.setPcompany(rs.getString("pcompany"));
				return cus;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
