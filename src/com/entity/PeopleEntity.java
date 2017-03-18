package com.entity;

public class PeopleEntity extends ParentEntity {

	private String phone;
	private String password;
	private int age;
	private int sex;
	private String nickName;
	
	public PeopleEntity(String phone, String password, int age, int sex,
			String nickName) {
		super();
		this.phone = phone;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.nickName = nickName;
	}
	
	public PeopleEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
