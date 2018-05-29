package edu.pune.university.dao;

import java.util.List;

import edu.pune.university.data.UserData;
import edu.pune.university.data.UserInfoTO;
import edu.pune.university.exception.ApplicationException;
import junit.framework.TestCase;

public class UserInfoDaoTest extends TestCase {
	UserInfoDao userInfoDao = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		userInfoDao = new UserInfoDao();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllUserData () {
		try {
			List<UserData> allUserData = userInfoDao.getAllUserData();
			for (UserData waterData : allUserData) {
				UserInfoTO userInfoTO = new UserInfoTO(waterData);
				System.out.println(userInfoTO);
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
