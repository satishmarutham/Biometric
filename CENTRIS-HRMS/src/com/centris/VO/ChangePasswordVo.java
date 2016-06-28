package com.centris.VO;

public class ChangePasswordVo {

	private String current_Password;
	private String new_Password;
	private String confirmnew_Password;
	private String userName;
	private String emial;;
	private String currentUserId;
	
	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getCurrent_Password() {
		return current_Password;
	}

	public void setCurrent_Password(String current_Password) {
		this.current_Password = current_Password;
	}

	public String getNew_Password() {
		return new_Password;
	}

	public void setNew_Password(String new_Password) {
		this.new_Password = new_Password;
	}

	public String getConfirmnew_Password() {
		return confirmnew_Password;
	}

	public void setConfirmnew_Password(String confirmnew_Password) {
		this.confirmnew_Password = confirmnew_Password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
}