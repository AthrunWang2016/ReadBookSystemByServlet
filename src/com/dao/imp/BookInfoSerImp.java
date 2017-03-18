package com.dao.imp;

import java.util.HashMap;
import java.util.List;

import com.entity.BookEntity;
import com.entity.PeopleEntity;

public interface BookInfoSerImp {

	public String saveInfo(BookEntity bookEntity);
    public String queryInfoById(String id);
    public String queryInfo(HashMap<String, String> which);
	public String updateInfo(BookEntity bookEntity);
	
}
