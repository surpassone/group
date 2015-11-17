package com.ssm.Bean;

public class paymentsDayBean {

	private String id;
	private String time;
	private double pay_mount;
	private String person_id;
	private String person_name;
	private String room_id;
	private String room_name;
	private String note;
	
	public String getId() {
		return id;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public double getPay_mount() {
		return pay_mount;
	}

	public void setPay_mount(double pay_mount) {
		this.pay_mount = pay_mount;
	}

	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
