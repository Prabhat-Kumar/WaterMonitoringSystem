package edu.pune.university.business;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.dao.UserInfoDao;
import edu.pune.university.data.UserData;
import edu.pune.university.data.UserInfoTO;
import edu.pune.university.exception.ApplicationException;
import edu.pune.university.service.rest.UserService;

/**
 * WaterDataBusiness class is responsible for holding the business logic for
 * user info. This class will interact with {@link UserInfoDao} for database
 * operations and with {@link UserService} for returning the result to
 * user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 *
 */
public class UserInfoBusiness {

	/**
	 * Instance variable declaration for {@link UserInfoDao}.
	 */
	private UserInfoDao userInfoDao = null;

	/**
	 * Create an instance of {@link UserInfoDao}.
	 */
	public UserInfoBusiness() {
		userInfoDao = new UserInfoDao();
	}

	/**
	 * Get all the {@link UserInfoTO} from {@link UserInfoDao}.
	 * @return {@link List} of {@link UserInfoTO}
	 * @throws ApplicationException
	 */
	public List<UserInfoTO> getAllUserInfoTOs() throws ApplicationException {
		List<UserInfoTO> UserInfoTOs = new ArrayList<UserInfoTO>();
		List<UserData> userDatas = userInfoDao.getAllUserData();
		for (UserData userData : userDatas) {
			UserInfoTOs.add(new UserInfoTO(userData));
		}
		return UserInfoTOs;
	}
}
