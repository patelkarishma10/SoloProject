package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.bae.business.service.UserService;

@Path("/user")
public class UserController {

	@Inject
	private UserService service;

}
