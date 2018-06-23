package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.product.bean.InhouseBean;

public class InhouseDao {
	private Connection conn;			//数据库连接对象
	private  PreparedStatement ps;	//执行SQl语句的对象
	private ResultSet rs;
	public boolean add(InhouseBean ub)  {
		String sql = "insert into inhouse(iname,inumber,isize,iprice,imodel,ibarcode,itime,pid,operator,operatorID,pcompany,incode) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ub.getIname());
			ps.setInt(2, ub.getInumber());
			ps.setString(3, ub.getIsize());
			ps.setDouble(4, ub.getIprice());
			ps.setString(5, ub.getImodel());
			ps.setString(6, ub.getIbarcode());
			ps.setString(7, ub.getItime());
			
			ps.setString(8, ub.getIid()+"");
			ps.setString(9, ub.getOperatorname());
			ps.setString(10, ub.getOperatorID());
			ps.setString(11, ub.getPcomplany());
			ps.setString(12, ub.getIncode());
			
			
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	
	
	
	public boolean del(int iid)  {
		String sql = "delete from inhouse where iid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, iid);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}
	
	public InhouseBean findById(int iid)
	{
		InhouseBean ub = null;
		String sql = "select * from inhouse where iid=?";
		try
		{
		conn = new DatabaseUtil().getConn();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, iid);
		rs = ps.executeQuery();
		while(rs.next())
		{
			ub = new InhouseBean();
			ub.setIid(rs.getInt("iid"));
			ub.setIname(rs.getString("iname"));
			ub.setInumber(rs.getInt("inumber"));
			ub.setIsize(rs.getString("isize"));
			ub.setIprice(rs.getDouble("iprice"));
			ub.setImodel(rs.getString("imodel"));
			ub.setIbarcode(rs.getString("ibarcode"));
			ub.setItime(rs.getString("itime"));
			ub.setOperatorname(rs.getString("operator"));
			ub.setPcomplany(rs.getString("pcompany"));
			ub.setIncode(rs.getString("incode"));
			
			
			return ub;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(InhouseBean ub)
	{
		String sql = "update inhouse set iname=?,inumber=?,isize=?,iprice=?,imodel=?,ibarcode=?,itime=?, operator=?,pcomplany=? where iid=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ub.getIname());
			ps.setInt(2, ub.getInumber());
			ps.setString(3, ub.getIsize());
			ps.setDouble(4, ub.getIprice());
			ps.setString(5, ub.getImodel());
			ps.setString(6, ub.getIbarcode());
			ps.setString(7, ub.getItime());
			ps.setString(8, ub.getOperatorname());
			ps.setString(9, ub.getPcomplany());
			ps.setInt(10,ub.getIid());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public List query(String flag) {
		List list = new ArrayList(20);
		String sql = "select * from inhouse where incode like ?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+flag+"%" );
			rs = ps.executeQuery();
			while(rs.next())
			{
				InhouseBean ub = new InhouseBean();
				
				ub.setIid(rs.getInt("iid"));
				ub.setIname(rs.getString("iname"));
				ub.setInumber(rs.getInt("inumber"));
				ub.setIsize(rs.getString("isize"));
				ub.setIprice(rs.getDouble("iprice"));
				ub.setImodel(rs.getString("imodel"));
				ub.setIbarcode(rs.getString("ibarcode"));
				ub.setItime(rs.getString("itime"));
				
				ub.setOperatorname(rs.getString("operator"));
				ub.setPcomplany(rs.getString("pcompany"));
				ub.setIncode(rs.getString("incode"));
				
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}
	
	
	public List queryAll(String field,String flag) {
		List list = new ArrayList(20);
		String sql = "select * from inhouse where (iname like ? or imodel like ? or ibarcode like ? or operator like ? or pcompany like ? ) and incode like ? ";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+field+"%" );
			ps.setString(2, "%"+field+"%" );
			ps.setString(3, "%"+field+"%" );
			ps.setString(4, "%"+field+"%" );
			ps.setString(5, "%"+field+"%" );
			
			ps.setString(6, "%"+flag+"%" );
			
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				InhouseBean ub = new InhouseBean();
				
				ub.setIid(rs.getInt("iid"));
				ub.setIname(rs.getString("iname"));
				ub.setInumber(rs.getInt("inumber"));
				ub.setIsize(rs.getString("isize"));
				ub.setIprice(rs.getDouble("iprice"));
				ub.setImodel(rs.getString("imodel"));
				ub.setIbarcode(rs.getString("ibarcode"));
				ub.setItime(rs.getString("itime"));
				
				ub.setOperatorname(rs.getString("operator"));
				ub.setPcomplany(rs.getString("pcompany"));
				ub.setIncode(rs.getString("incode"));
				
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}
	
	
	public List queryAll(String field,String loginuserId,String flag) {
		List list = new ArrayList(20);		
		
		try {
			conn = new DatabaseUtil().getConn();
			
			String sql = "select * from inhouse where (iname like ? or imodel like ? or ibarcode like ? or operator like ? or pcompany like ? ) and operatorID = ? and incode like ?";
			if(null==field||"".equals(field)){
				sql = "select * from inhouse where operatorID = ? and incode like ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(loginuserId));
				ps.setString(2, "%"+flag+"%" );
			}else{
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+field+"%" );
				ps.setString(2, "%"+field+"%" );
				ps.setString(3, "%"+field+"%" );
				ps.setString(4, "%"+field+"%" );
				ps.setString(5, "%"+field+"%" );
//				ps.setString(6, "%"+field+"%" );				
				ps.setInt(6, Integer.parseInt(loginuserId));
				ps.setString(7, "%"+flag+"%" );
			}
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				InhouseBean ub = new InhouseBean();
				
				ub.setIid(rs.getInt("iid"));
				ub.setIname(rs.getString("iname"));
				ub.setInumber(rs.getInt("inumber"));
				ub.setIsize(rs.getString("isize"));
				ub.setIprice(rs.getDouble("iprice"));
				ub.setImodel(rs.getString("imodel"));
				ub.setIbarcode(rs.getString("ibarcode"));
				ub.setItime(rs.getString("itime"));
				
				ub.setOperatorname(rs.getString("operator"));
				ub.setPcomplany(rs.getString("pcompany"));
				ub.setIncode(rs.getString("incode"));
				
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		
	}



}
