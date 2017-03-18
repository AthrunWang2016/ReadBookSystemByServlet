package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.dao.imp.PeopleInfoDaoImp;
import com.entity.PeopleEntity;
import com.tool.SystemLogOut;

public class PeopleInfoDao extends InfoDao implements PeopleInfoDaoImp {

	public PeopleInfoDao() {
		super();
	}

	@Override
	public PeopleEntity queryInfo(HashMap<String, String> which) {
		PeopleEntity peopleEntity = null;
		try {
			sqlStr = "select * from people_table where 1=1";
			Iterator<Entry<String, String>> iter = which.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, String> entry = (Entry<String, String>) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				sqlStr = sqlStr + " and " + key + "='" + val +"'";
//				SystemLogOut.getInstance().printOut(sqlStr);
			}
			ResultSet rs = connection.executeQuery(sqlStr);
			if(rs == null){
				return null;
			}
			while (rs.next()) {
				peopleEntity = new PeopleEntity();
				peopleEntity.setId(rs.getInt(1));
				peopleEntity.setName(rs.getString(2));
				peopleEntity.setSex(rs.getInt(3));
				peopleEntity.setAge(rs.getInt(4));
				peopleEntity.setImg(rs.getString(5));
				peopleEntity.setPassword(rs.getString(6));
				peopleEntity.setPhone(rs.getString(7));
				peopleEntity.setNickName(rs.getString(8));
				peopleEntity.setKind(rs.getInt(9));
			}
		} catch (SQLException ex) {		
			return null;
		} finally {
			connection.closeConnection();
		}
		return peopleEntity;
	}

	@Override
	public boolean saveInfo(PeopleEntity peopleEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(PeopleEntity peopleEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		
	}
	
}
