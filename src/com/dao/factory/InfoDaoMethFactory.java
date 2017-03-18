/*package com.dao.factory;

import java.util.HashMap;
import java.util.List;

import com.dao.BookInfoDao;
import com.dao.InfoDao;
import com.dao.PeopleInfoDao;
import com.tool.SystemLogOut;

public class InfoDaoMethFactory {

	private final int PEOPLETABLE = 0;
	private final int BOOKTABLE = 0;
	
	public List queryInfoCreator(int kind,HashMap<String, String> which) {
		switch (kind) {
			case PEOPLETABLE:
				//InfoDaoFactory.getInstance().peopleCreator().queryInfo(which);
				break;
			case BOOKTABLE:
				return InfoDaoFactory.getInstance().bookCreator().queryInfo(which);
				break;
		}
	}
}
*/