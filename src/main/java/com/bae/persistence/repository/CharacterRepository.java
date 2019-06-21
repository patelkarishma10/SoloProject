package com.bae.persistence.repository;

public interface CharacterRepository {

	// C
	String createCharater(String characters);

	// R
	String getAllCharacters();

	// U
	String updateCharacterDetails(int id, String character);

	// D
	String deleteCharacter(int id);
}
