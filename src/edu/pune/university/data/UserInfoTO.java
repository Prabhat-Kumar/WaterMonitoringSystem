package edu.pune.university.data;

/**
 * {@link UserInfoTO} is transfer object for {@link UserData}. The
 * {@link UserData} information will be converted to {@link UserInfoTO} before
 * sending to user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 */
public class UserInfoTO {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfoTO [userName=" + userName + ", password=" + password + "]";
	}

	private String userName;
	private String password;

	/**
	 * Get {@link UserInfoTO} using {@link UserData}.
	 * @param userData {@link UserData}
	 */
	public UserInfoTO(UserData userData) {
		this.userName = userData.getUserName();
		this.password = userData.getPassword();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



}
