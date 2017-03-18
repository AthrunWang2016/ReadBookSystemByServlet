package com.dao;

import com.tool.DBHelper;

public class InfoDao {

	DBHelper connection = null;
	String sqlStr = null;
	
	public InfoDao() {
		connection = new DBHelper();
	}
	
	public void closeDB() {
		if(connection != null){
			connection.closeConnection();
		}
	}
	
}
