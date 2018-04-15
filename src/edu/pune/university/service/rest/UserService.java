package edu.pune.university.service.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserService {

	@GET
	@Path("/authenticate")
	public boolean authenticateUser(@FormParam("userName") String userName, @FormParam("password") String password) {
		if (userName.equals("Maya") && password.equals("Root")) {
			return true;
		}
		return false;
	}
}
