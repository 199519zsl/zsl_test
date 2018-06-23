package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.product.bean.UserBean;


public class UserDao {
	
	private Connection conn;			//���ݿ����Ӷ���
	private  PreparedStatement ps;	//ִ��SQl���Ķ���
	private ResultSet rs;

		

	public UserBean login(UserBean ub)//��¼����û���Ϣ
	{
		String username = ub.getUsername();
		String pwd = ub.getPwd();
		String type=ub.getUsertype();
		
		String sql = "select * from users where username=? and pwd=? and usertype=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,pwd);
			ps.setString(3,type);
			rs = ps.executeQuery();
			while(rs.next())
			{
				ub.setId(rs.getInt("id"));
				ub.setUsername(rs.getString("username"));
				ub.setPwd(rs.getString("pwd"));
				ub.setUsertype(rs.getString("usertype"));
				return ub;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public UserBean searchById(int id)//�����û�ID��ѯ�û�
	{
		
		
		String sql = "select * from users where id=?";
		try {
			UserBean ub=new UserBean();
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				ub.setId(rs.getInt("id"));
				ub.setUsername(rs.getString("username"));
				ub.setPwd(rs.getString("pwd"));
				ub.setUsertype(rs.getString("usertype"));
				return ub;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean add(UserBean user) throws SQLException {//����û���Ϣ
		String sql = "insert into users values(?,?,?,?)";
		try {
			
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getUsertype());
			
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	
	public boolean del(int id)  {//ɾ���û���Ϣ
		String sql = "delete from users where id=?";
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
	
	public boolean update(UserBean user) throws SQLException {//�޸��û���Ϣ

		String sql = "update users set username=?,pwd=?,usertype=?where id=?";
		try {
			conn = new DatabaseUtil().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(4, user.getId());
			ps.setString(2, user.getPwd());
			ps.setString(1, user.getUsername());
			ps.setString(3, user.getUsertype());
		
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
	 * ��ѯ���е��û���Ϣ
	 */
	public List findAll(String name)
	{
		List list = new ArrayList(30);
		
		try {
			
			conn = new DatabaseUtil().getConn();
			
			if( name !="")
			{
				String sql = "select * from users where username like ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+ name+"%" );
			}
			else
			{
				String sql = "select * from users";
				ps = conn.prepareStatement(sql);
				
			}
			rs = ps.executeQuery();
			while(rs.next())
			{
				UserBean ub = new UserBean();
				ub.setId(rs.getInt("id"));
				ub.setUsername(rs.getString("username"));
				ub.setPwd(rs.getString("pwd"));
				ub.setUsertype(rs.getString("usertype"));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void query(UserBean user) throws SQLException {
		String sql = "insert into t_user values(?,?,?,?,?,?)";
	
		
	}

}
