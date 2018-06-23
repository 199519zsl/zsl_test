package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.CustomerBean;
import com.product.bean.GoodsBean;
import com.product.bean.UserBean;

public class GoodsDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	
	
	public boolean add(GoodsBean ub)  {
		String sql = "insert into goodsinf values(?,?,?,?,?,?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,ub.getGid());
			ps.setString(2, ub.getGname());
			ps.setInt(3, ub.getGnumber());
			ps.setDouble(4, ub.getGprice());
			ps.setString(5, ub.getGsize());
			ps.setString(6, ub.getGmodel());
			ps.setString(7, ub.getGbarcode());
			ps.setString(8, ub.getGclass());
			ps.setString(9, ub.getGremark());
			
			
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean del(int gid)  {
		String sql = "delete from goodsinf where gid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}
	
	public GoodsBean findById(int gid)
	{
		GoodsBean ub = null;
		String sql = "select * from goodsinf where gid=?";
		try
		{
		conn = new DatabaseUtil().getConn();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, gid);
		rs = ps.executeQuery();
		while(rs.next())
		{
			ub = new GoodsBean();
			ub.setGid(rs.getInt("gid"));
			ub.setGname(rs.getString("gname"));
			ub.setGnumber(rs.getInt("gnumber"));
			ub.setGprice(rs.getDouble("gprice"));
			ub.setGsize(rs.getString("gsize"));
			ub.setGmodel(rs.getString("gmodel"));
			ub.setGbarcode(rs.getString("gbarcode"));
			ub.setGclass(rs.getString("gclass"));
			ub.setGremark(rs.getString("gremark"));
				

			
			return ub;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(GoodsBean ub)
	{
		String sql = "update goodsinf set gname=?,gnumber=?,gprice=?,gsize=?,gmodel=?,gbarcode=?,gclass=?,gremark=?where gid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ub.getGname());
			ps.setInt(2, ub.getGnumber());
			ps.setDouble(3, ub.getGprice());
			ps.setString(4, ub.getGsize());
			ps.setString(5, ub.getGmodel());
			ps.setString(6, ub.getGbarcode());
			ps.setString(7, ub.getGclass());
			ps.setString(8, ub.getGremark());
			ps.setInt(9,ub.getGid());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public List query() {
		List list = new ArrayList(20);
		String sql = "select * from goodsinf";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				GoodsBean ub = new GoodsBean();
				
				ub.setGid(rs.getInt("gid"));
				ub.setGname(rs.getString("gname"));
				ub.setGnumber(rs.getInt("gnumber"));
				ub.setGprice(rs.getDouble("gprice"));
				ub.setGsize(rs.getString("gsize"));
				ub.setGmodel(rs.getString("gmodel"));
				ub.setGbarcode(rs.getString("gbarcode"));
				ub.setGclass(rs.getString("gclass"));
				ub.setGremark(rs.getString("gremark"));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}
	
	
	public List queryAll(String name) {
		List list = new ArrayList();
		String sql = "select * from goodsinf where gname like ?";
		try {
			conn = new DatabaseUtil().getConn();
			
			if (null==name||"".equals(name)) {
				sql = "select * from goodsinf";
				ps = conn.prepareStatement(sql);
			}else{
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+name+"%" );
			}
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				GoodsBean ub = new GoodsBean();
				
				ub.setGid(rs.getInt("gid"));
				ub.setGname(rs.getString("gname"));
				ub.setGnumber(rs.getInt("gnumber"));
				ub.setGprice(rs.getDouble("gprice"));
				ub.setGsize(rs.getString("gsize"));
				ub.setGmodel(rs.getString("gmodel"));
				ub.setGbarcode(rs.getString("gbarcode"));
				ub.setGclass(rs.getString("gclass"));
				ub.setGremark(rs.getString("gremark"));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}


}
