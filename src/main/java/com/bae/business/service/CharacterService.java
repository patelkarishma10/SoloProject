package com.bae.business.service;

public interface CharacterService {
	// C
	String createCharacter(String characters);

	// R
	String getAllCharacters();

	// U
	String updateCharacterDetails(int id, String character);

	// D
	String deleteCharacter(int id);
}
