package com.cthulhu.entity;

public class UserInfoBean {
	private String id;
	private String name;
	private String password;

	/********************************************** Constructor ****************************************/
	public UserInfoBean(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/********************************************** Getter ********************************************/
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	/********************************************** Setter ********************************************/
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/********************************************** Other *********************************************/
	@Override
	public String toString() {
		return "UserInfoBean{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}

}
