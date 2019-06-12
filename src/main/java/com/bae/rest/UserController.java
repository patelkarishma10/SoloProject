package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.UserService;

@Path("/user")
public class UserController {

	@Inject
	private UserService service;

	@Path("/getAUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAUser(@PathParam("id") int id) {
		return service.getAUser(id);
	}

}
