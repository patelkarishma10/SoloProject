package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.service.FilmService;

@Path("/film")
public class FilmController {

	@Inject
	private FilmService service;

	@Path("/getAllFilms")
	@GET
	@Produces({ "application/json" })
	public String getAllFilms() {
		return service.getAllFilms();
	}
}
