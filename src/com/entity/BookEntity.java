package com.entity;

public class BookEntity extends ParentEntity {

	private String price;
	private String num;
	private int  editerId;
	private String content;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getEditerId() {
		return editerId;
	}
	public void setEditerId(int editerId) {
		this.editerId = editerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
