package edu.pune.university.data;

import org.bson.Document;

public class UserData extends Document{
	private static final long serialVersionUID = 1L;
	private String userName ="userName";
	private String password ="password";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
