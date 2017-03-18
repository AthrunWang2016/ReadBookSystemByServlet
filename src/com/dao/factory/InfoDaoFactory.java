package com.dao.factory;

import com.dao.BookInfoDao;
import com.dao.InfoDao;
import com.dao.PeopleInfoDao;
import com.tool.SystemLogOut;

public class InfoDaoFactory {

	InfoDao infoDao = null;
	private static InfoDaoFactory infoDaoFactory = null;
	
	private InfoDaoFactory() {
		// TODO Auto-generated constructor stub
	}
	public static InfoDaoFactory getInstance() {
		if(infoDaoFactory == null){
			infoDaoFactory = new InfoDaoFactory();
		}
		return infoDaoFactory;
	}
	
	public PeopleInfoDao peopleCreator(){
		infoDao = new PeopleInfoDao();
        return (PeopleInfoDao) infoDao;
    }
	
	public BookInfoDao bookCreator(){
		infoDao = new BookInfoDao();
        return (BookInfoDao) infoDao;
    }
	
	/*public Object creator(String className){
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			SystemLogOut.getInstance().printOut(e.getMessage());
		} 
        return obj;
    }*/
	
}
