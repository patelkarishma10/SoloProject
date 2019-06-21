package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		return service.createCharacter(characters);
	}

	@Path("/deleteCharacter/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCharacter(@PathParam("id") int id) {
		return service.deleteCharacter(id);
	}

	@Path("/updateCharacter/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCharacterDetails(@PathParam("id") int id, String character) {
		return service.updateCharacterDetails(id, character);
	}

	public void setService(CharacterService service) {
		this.service = service;
	}
}
