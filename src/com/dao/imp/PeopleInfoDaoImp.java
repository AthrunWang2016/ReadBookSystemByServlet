package com.dao.imp;

import java.util.HashMap;

import com.entity.PeopleEntity;

public interface PeopleInfoDaoImp {

	public boolean saveInfo(PeopleEntity peopleEntity);
    public PeopleEntity queryInfo(HashMap<String, String> which);
	public boolean updateInfo(PeopleEntity peopleEntity);
	
}
