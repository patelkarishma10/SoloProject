package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String user) {
		return service.createUser(user);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") int id) {
		return service.deleteUser(id);
	}

	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUserDetails(@PathParam("id") int id, String user) {
		return service.updateUserDetails(id, user);
	}

	@Path("/addFavFilm/{user_id}/{film_id}")
	@POST
	@Produces({ "application/json" })
	public String addFavouriteFilm(@PathParam("user_id") int userId, @PathParam("film_id") int filmId) {
		return service.addFavouriteFilm(userId, filmId);
	}

	@Path("/deleteFavFilm/{user_id}/{film_id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteFavouriteFilm(@PathParam("user_id") int userId, @PathParam("film_id") int filmId) {
		return service.deleteFavouriteFilm(userId, filmId);
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
