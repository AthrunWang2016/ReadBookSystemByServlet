package com.dao.imp;

import java.util.HashMap;

import com.entity.PeopleEntity;

public interface PeopleInfoSerImp {

	public String saveInfo(PeopleEntity peopleEntity);
    public String queryInfo(HashMap<String, String> which);
	public String updateInfo(PeopleEntity peopleEntity);
	
}
