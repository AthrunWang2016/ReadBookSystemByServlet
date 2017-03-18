package com.tool;

import java.sql.*;

public class DBHelper {
	private String dbDriver = Constant.dbDriver;
	private String url = Constant.url;
	private String userName = Constant.userName;
	private String password = Constant.password;
	private ResultSet rs = null;
	private Statement stmt = null;
	private Connection con = null;

	public DBHelper() {
		try {
			Class.forName(dbDriver);
		} catch (Exception ex) {
			System.out.println(" ˝æ›ø‚º”‘ÿ ß∞‹");
		}
	}

	private boolean creatConnection() {
		try {
			con = DriverManager.getConnection(url, userName, password);
			con.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean executeUpdate(String sql) {
		if (null == con) {
			creatConnection();
		}
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ResultSet executeQuery(String sql) {
		try {
			if (null == con) {
				creatConnection();
			}
			stmt = con.createStatement();
			try {
				rs = stmt.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}

	public void closeConnection() {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				con = null;
			}
		}
	}
	
	/*public static void main(String[] args) {
		DBHelper d = new DBHelper();
		System.out.println(d.creatConnection());
	}*/
	
}
