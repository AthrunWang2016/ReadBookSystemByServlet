package com.entity;

import java.util.List;

public class ResultMsgEntity<T> {

	String result;
	String msg;
	T entity;
	List<T> entities;
	
	public ResultMsgEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultMsgEntity(String result, String msg, T entity,
			List<T> entities) {
		super();
		this.result = result;
		this.msg = msg;
		this.entity = entity;
		this.entities = entities;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public List<T> getEntities() {
		return entities;
	}
	public void setEntities(List<T> entities) {
		this.entities = entities;
	}
}
