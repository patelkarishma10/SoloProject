package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.CharacterRepository;

public class CharacterServiceImpl implements CharacterService {

	@Inject
	private CharacterRepository repo;

	@Override
	public String getAllCharacters() {
		return repo.getAllCharacters();
	}

	@Override
	public String deleteCharacter(int id) {
		return repo.deleteCharacter(id);
	}

	@Override
	public String updateCharacterDetails(int id, String character) {
		return repo.updateCharacterDetails(id, character);
	}

	@Override
	public String createCharacter(String characters) {
		return repo.createCharacter(characters);

	}

}
