package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.service.CharacterService;

@Path("/character")
public class CharacterController {

	@Inject
	private CharacterService service;

	@Path("/getAllCharacters")
	@GET
	@Produces({ "application/json" })
	public String getAllCharacters() {
		return service.getAllCharacters();
	}

	@Path("/createCharacter")
	@POST
	@Produces({ "application/json" })
	public String createCharater(String characters) {
		return service.createCharater(characters);
	}

}
