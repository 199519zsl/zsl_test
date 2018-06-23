package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	

		private Connection conn;
		//连接数据库的方法
		public Connection getConn()
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/product";
				String username = "root";
				String password = "199519zsl";
				conn = DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	
	
	 private int update(Connection conn, boolean closeConn, String sql) throws SQLException {
	        if (conn == null) {
	            throw new SQLException("Null connection");
	        }

	        if (sql == null) {
	            if (closeConn) {
	                close(conn);
	            }
	            throw new SQLException("Null SQL statement");
	        }

	        PreparedStatement stmt = null;
	        int rows = 0;

	        try {
	        	stmt = conn.prepareStatement(sql);
	            rows = stmt.executeUpdate();

	        } catch (SQLException e) {
	        	throw new SQLException("SQL statement"+e.getMessage());

	        } finally {
	            close(stmt);
	            if (closeConn) {
	                close(conn);
	            }
	        }

	        return rows;
	    }
	 
	 
	 private int del(Connection conn, boolean closeConn, String sql) throws SQLException {
	        if (conn == null) {
	            throw new SQLException("Null connection");
	        }

	        if (sql == null) {
	            if (closeConn) {
	                close(conn);
	            }
	            throw new SQLException("Null SQL statement");
	        }

	        PreparedStatement stmt = null;
	        int rows = 0;

	        try {
	        	stmt = conn.prepareStatement(sql);
	            rows = stmt.executeUpdate();

	        } catch (SQLException e) {
	        	throw new SQLException("SQL statement"+e.getMessage());

	        } finally {
	            close(stmt);
	            if (closeConn) {
	                close(conn);
	            }
	        }

	        return rows;
	    }
	 
	 
	 
	 private ResultSet query(Connection conn, boolean closeConn, String sql) throws SQLException {
	        if (conn == null) {
	            throw new SQLException("Null connection");
	        }

	        if (sql == null) {
	            if (closeConn) {
	                close(conn);
	            }
	            throw new SQLException("Null SQL statement");
	        }

	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        

	        try {
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();

	        } catch (SQLException e) {
	        	throw new SQLException("SQL statement"+e.getMessage());

	        } finally {
	            close(stmt);
	            if (closeConn) {
	                close(conn);
	            }
	        }

	        return rs;
	    }
	 
	 
	    public static void close(Connection conn) throws SQLException {
	        if (conn != null) {
	            conn.close();
	        }
	    }
	    
	    
	    public static void close(Statement stmt) throws SQLException {
	        if (stmt != null) {
	            stmt.close();
	        }
	    }
	    
	    
	    
	    
	    public static void close(ResultSet rs) throws SQLException {
	        if (rs != null) {
	            rs.close();
	        }
	    }

}
