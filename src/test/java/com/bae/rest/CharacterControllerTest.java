package com.bae.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.CharacterService;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class CharacterControllerTest {
	@InjectMocks
	private CharacterController controller;

	@Mock
	private CharacterService service;

	@Before
	public void setup() {
		controller.setService(service);

	}

	@Test
	public void getAllCharactersTest() {
		Mockito.when(service.getAllCharacters()).thenReturn(Constants.MOCK_CHARACTER_ARRAY);
		assertEquals(Constants.MOCK_CHARACTER_ARRAY, controller.getAllCharacters());
	}

	@Test
	public void createCharacterTest() {
		Mockito.when(service.createCharacter(Constants.MOCK_CHARACTER_OBJECT))
				.thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, controller.createCharater(Constants.MOCK_CHARACTER_OBJECT));

	}

	@Test
	public void deleteCharacterTest() {
		Mockito.when(service.deleteCharacter(1)).thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, controller.deleteCharacter(1));

	}

	@Test
	public void updateCharacterDetailsTest() {
		String characterString = Constants.MOCK_CHARACTER_OBJECT;
		Mockito.when(service.updateCharacterDetails(1, characterString)).thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, controller.updateCharacterDetails(1, characterString));

	}

}
