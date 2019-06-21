package com.bae.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharacterTest {
	@Test
	public void characterTest() {
		Characters character = new Characters(1, "character");

		character.setId(2);
		character.setName("testCharacter");

		assertEquals(2, character.getId());
		assertEquals("testCharacter", character.getName());

	}
}
