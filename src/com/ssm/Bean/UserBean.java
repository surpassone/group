package com.ssm.Bean;

public class UserBean {
	private String id;


	//	private String createtime;
	//姓名（真实）
	private String person_name;
	private String username;
	private String password;
	//所属宿舍ID
	private String room_id;
	private String room_name;
	//性别：0-男 1-女
	private int sex;
	//用户状态：0-正常 1-注销
	private int state;

	private String note;
	
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRoom_name() {
		return room_name;
	}


	public String getId() {
		return id;
	}

public void setId(String id) {
		this.id = id;
	}


}
