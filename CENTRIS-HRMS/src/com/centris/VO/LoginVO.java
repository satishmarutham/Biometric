package com.centris.VO;



public class LoginVO {

	private   String userCode;
	private   String UserName;
	private   String PassWord;


	public   String getUserName() {
 		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public   String getPassWord() {

		return PassWord;
	}
	public   void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 

 


}
