package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.product.bean.OuthouseBean;

public class OuthouseDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	public boolean add(OuthouseBean ub)  {
		String sql = "insert into Outhouse values(?,?,?,?,?,?,?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,ub.getOid());
			ps.setString(2, ub.getOname());
			ps.setInt(3, ub.getOnumber());
			ps.setString(4, ub.getOsize());
			ps.setDouble(5, ub.getOprice());
			ps.setString(6, ub.getOmodel());
			ps.setString(7, ub.getObarcode());
			ps.setString(8, ub.getOtime());
			ps.setString(9, ub.getUsername());
			ps.setString(10, ub.getCucomplany());
			
			
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	
	
	
	public boolean del(int oid)  {
		String sql = "delete from outhouse where oid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}
	
	public OuthouseBean findById(int Oid)
	{
		OuthouseBean ub = null;
		String sql = "select * from outhouse where iid=?";
		try
		{
		conn = new DatabaseUtil().getConn();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Oid);
		rs = ps.executeQuery();
		while(rs.next())
		{
			ub = new OuthouseBean();
			ub.setOid(rs.getInt("oid"));
			ub.setOname(rs.getString("oname"));
			ub.setOnumber(rs.getInt("onumber"));
			ub.setOsize(rs.getString("osize"));
			ub.setOprice(rs.getDouble("oprice"));
			ub.setOmodel(rs.getString("omodel"));
			ub.setObarcode(rs.getString("obarcode"));
			ub.setOtime(rs.getString("otime"));
			ub.setUsername(rs.getString("username"));
			ub.setCucomplany(rs.getString("cucomplany"));
			
			
			return ub;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(OuthouseBean ub)
	{
		String sql = "update outhouse set oname=?,onumber=?,osize=?,oprice=?,omodel=?,obarcode=?,otime=?, username=?,cucomplany=?,where oid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ub.getOname());
			ps.setInt(2, ub.getOnumber());
			ps.setString(3, ub.getOsize());
			ps.setDouble(4, ub.getOprice());
			ps.setString(5, ub.getOmodel());
			ps.setString(6, ub.getObarcode());
			ps.setString(7, ub.getOtime());
			ps.setString(8, ub.getUsername());
			ps.setString(9, ub.getCucomplany());
			ps.setInt(10,ub.getOid());
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
		String sql = "select * from outhouse";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				OuthouseBean ub = new OuthouseBean();
				
				ub.setOid(rs.getInt("oid"));
				ub.setOname(rs.getString("oname"));
				ub.setOnumber(rs.getInt("onumber"));
				ub.setOsize(rs.getString("osize"));
				ub.setOprice(rs.getDouble("oprice"));
				ub.setOmodel(rs.getString("omodel"));
				ub.setObarcode(rs.getString("obarcode"));
				ub.setOtime(rs.getString("otime"));
				ub.setUsername(rs.getString("username"));
				ub.setCucomplany(rs.getString("cucomplany"));
				
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}


}
