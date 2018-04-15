package edu.pune.university.service.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserService {

	@POST
	@Path("/authenticate")
	public boolean authenticateUser() {
		return true;
	}
}
