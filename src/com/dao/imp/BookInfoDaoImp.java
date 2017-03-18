package com.dao.imp;

import java.util.HashMap;
import java.util.List;

import com.entity.BookEntity;

public interface BookInfoDaoImp {

	public boolean saveInfo(BookEntity bookEntity);
    public BookEntity queryInfoById(String id);
    public List<BookEntity> queryInfo(HashMap<String, String> which);
	public boolean updateInfo(BookEntity bookEntity);
	
}
