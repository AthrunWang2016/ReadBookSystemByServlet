package com.servise;

import java.util.HashMap;
import java.util.List;

import com.dao.factory.InfoDaoFactory;
import com.dao.imp.BookInfoDaoImp;
import com.dao.imp.BookInfoSerImp;
import com.dao.imp.PeopleInfoDaoImp;
import com.dao.imp.PeopleInfoSerImp;
import com.entity.BookEntity;
import com.entity.PeopleEntity;
import com.entity.ResultMsgEntity;
import com.google.gson.Gson;
import com.tool.SystemLogOut;

public class BookInfoServise implements BookInfoSerImp{

	@Override
	public String queryInfo(HashMap<String, String> which) {
		ResultMsgEntity<BookEntity> resultMsgEntity = new ResultMsgEntity<BookEntity>();
		Gson gson = new Gson();
		BookInfoDaoImp bookInfoDaoImp = InfoDaoFactory.getInstance().bookCreator();
		if(bookInfoDaoImp == null){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("系统出错");
			return gson.toJson(resultMsgEntity);
		}
		List<BookEntity> bookEntities = bookInfoDaoImp.queryInfo(which);
		if(bookEntities.size()==0){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("获取书本信息错误");
			return gson.toJson(resultMsgEntity);
		}
		resultMsgEntity.setResult("true");
		resultMsgEntity.setMsg("获得书本信息");
		resultMsgEntity.setEntities(bookEntities);
		return gson.toJson(resultMsgEntity);
	}

	@Override
	public String queryInfoById(String id) {
		ResultMsgEntity<BookEntity> resultMsgEntity = new ResultMsgEntity<BookEntity>();
		Gson gson = new Gson();
//		PeopleInfoDaoImp peopleInfoDaoImp = (PeopleInfoDaoImp) InfoDaoFactory.getInstance().creator("PeopleInfoDao");
		BookInfoDaoImp bookInfoDaoImp = InfoDaoFactory.getInstance().bookCreator();
		if(bookInfoDaoImp == null){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("系统出错");
			return gson.toJson(resultMsgEntity);
		}
		
		BookEntity bookEntity = bookInfoDaoImp.queryInfoById(id);
		if(bookEntity == null){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("获取书本信息错误");
			return gson.toJson(resultMsgEntity);
		}
		
		resultMsgEntity.setResult("true");
		resultMsgEntity.setMsg("获得书本信息");
		resultMsgEntity.setEntity(bookEntity);
		return gson.toJson(resultMsgEntity);
	}

	@Override
	public String saveInfo(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInfo(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
