package edu.pune.university.service.rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import edu.pune.university.business.UserInfoBusiness;
import edu.pune.university.data.UserInfoTO;
import edu.pune.university.exception.ApplicationException;

@Path("/user")
public class UserService {
	
	/**
	 * Instance variable declaration for {@link UserInfoBusiness}.
	 */
	private UserInfoBusiness userInfoBusiness = null;

	/**
	 * Create an instance of {@link UserInfoBusiness}.
	 */
	public UserService() {
		userInfoBusiness = new UserInfoBusiness();
	}

	@POST
	@Path("/authenticate")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticateUser(@FormParam("userName") String userName, @FormParam("password") String password) throws ApplicationException {
		boolean authenticated = false;
		List<UserInfoTO> allUserInfoTOs = userInfoBusiness.getAllUserInfoTOs();
		for (UserInfoTO userInfoTO : allUserInfoTOs) {
			if (userInfoTO.getUserName().equals(userName) && userInfoTO.getPassword().equals(password)) {
				authenticated = true;
			}
		}
		return new Gson().toJson(authenticated);
	}
}
