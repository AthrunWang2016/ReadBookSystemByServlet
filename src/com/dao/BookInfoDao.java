package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dao.imp.BookInfoDaoImp;
import com.entity.BookEntity;
import com.entity.PeopleEntity;
import com.tool.DBHelper;
import com.tool.SystemLogOut;

public class BookInfoDao extends InfoDao implements BookInfoDaoImp {

	private String name = "name";
	private String price = "price";
	private String num = "num";
	
	public BookInfoDao() {
		super();
	}

	@Override
	public List<BookEntity> queryInfo(HashMap<String, String> which) {
		List<BookEntity> bookEntities = new ArrayList<BookEntity>();
		BookEntity bookEntity = null;
		
		if(which == null){
			which = new HashMap<String, String>();
			which.put("1", "1");
		}
		
		try {
			sqlStr = "select * from book_table where 1=1";
			Iterator<Entry<String, String>> iter = which.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, String> entry = (Entry<String, String>) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				SystemLogOut.getInstance().setPrintOut(true);
				//sqlStr = sqlStr + " and " + key + "='" + val +"'";
				if(key.equals(name)){
					sqlStr = sqlStr + " and " + key + "like '%" + val +"%'";
				}else if(key.equals(price)){
					String min="0",max="999999";
					if(price.indexOf("-")>0){
						max = price.substring(price.indexOf("-")+1);
						min = price.substring(0,price.indexOf("-")-1);
					}
					sqlStr = sqlStr + " and " + key + ">" + min  + " and " + "<" + max;
				}else{
					sqlStr = sqlStr + " and " + key + "='" + val +"'";
				}
				SystemLogOut.getInstance().printOut(sqlStr);
			}
			ResultSet rs = connection.executeQuery(sqlStr);
			while (rs.next()) {
				bookEntity = new BookEntity();
				bookEntity.setId(rs.getInt(1));
				bookEntity.setName(rs.getString(2));
				bookEntity.setPrice(rs.getString(3));
				bookEntity.setNum(rs.getString(4));
				bookEntity.setKind(rs.getInt(5));
				bookEntity.setEditerId(rs.getInt(6));
				bookEntity.setImg(rs.getString(7));
				bookEntity.setContent(rs.getString(8));
				bookEntities.add(bookEntity);
			}
		} catch (SQLException ex) {		
			SystemLogOut.getInstance().printOut(ex.getMessage());
		} finally {
			connection.closeConnection();
		}
		return bookEntities;
	}

	@Override
	public boolean saveInfo(BookEntity userinfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(BookEntity userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 按条形码查书
	 * id:条形码
	 */
	@Override
	public BookEntity queryInfoById(String id) {
		BookEntity bookEntity = null;
		try {
			sqlStr = "select * from book_table where num = '" + id +"'";
			ResultSet rs = connection.executeQuery(sqlStr);
			if(rs == null){
				return null;
			}
			while (rs.next()) {
				bookEntity = new BookEntity();
				bookEntity.setId(rs.getInt(1));
				bookEntity.setName(rs.getString(2));
				bookEntity.setPrice(rs.getString(3));
				bookEntity.setNum(rs.getString(4));
				bookEntity.setKind(rs.getInt(5));
				bookEntity.setEditerId(rs.getInt(6));
				bookEntity.setImg(rs.getString(7));
				bookEntity.setContent(rs.getString(8));
			}
		} catch (SQLException ex) {		
			return null;
		} finally {
			connection.closeConnection();
		}
		return bookEntity;
	}

	/*public static void main(String[] args) {
		HashMap h = new HashMap<String, String>();
		h.put("id", "2");
		SystemLogOut.getInstance().printOut(new BookInfoDao().queryInfo(h).getName());
	}*/
	
}
