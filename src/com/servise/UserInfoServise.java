package com.servise;

import java.util.HashMap;

import com.dao.factory.InfoDaoFactory;
import com.dao.imp.PeopleInfoDaoImp;
import com.dao.imp.PeopleInfoSerImp;
import com.entity.PeopleEntity;
import com.entity.ResultMsgEntity;
import com.google.gson.Gson;
import com.tool.SystemLogOut;

public class UserInfoServise implements PeopleInfoSerImp{

	@Override
	public String queryInfo(HashMap<String, String> which) {
		
		SystemLogOut.getInstance().setPrintOut(true);
		
		ResultMsgEntity<PeopleEntity> resultMsgEntity = new ResultMsgEntity<PeopleEntity>();
		Gson gson = new Gson();
//		PeopleInfoDaoImp peopleInfoDaoImp = (PeopleInfoDaoImp) InfoDaoFactory.getInstance().creator("PeopleInfoDao");
		PeopleInfoDaoImp peopleInfoDaoImp = InfoDaoFactory.getInstance().peopleCreator();
		if(peopleInfoDaoImp == null){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("ϵͳ����");
			return gson.toJson(resultMsgEntity);
		}
		
		PeopleEntity peopleEntity = peopleInfoDaoImp.queryInfo(which);
		if(peopleEntity == null){
			resultMsgEntity.setResult("false");
			resultMsgEntity.setMsg("�û������������");
			return gson.toJson(resultMsgEntity);
		}
		
		resultMsgEntity.setResult("true");
		resultMsgEntity.setMsg("����û���Ϣ");
		resultMsgEntity.setEntity(peopleEntity);
		return gson.toJson(resultMsgEntity);
	}

	@Override
	public String saveInfo(PeopleEntity peopleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInfo(PeopleEntity peopleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public static void main(String[] args) {
		PeopleInfoSerImp userInfoServise = new UserInfoServise();
		HashMap<String, String> which = new HashMap<String, String>();
		which.put("name", "user_1111");
		which.put("password", "123");
		SystemLogOut.getInstance().printOut(userInfoServise.queryInfo(which));
	}*/
	
}
