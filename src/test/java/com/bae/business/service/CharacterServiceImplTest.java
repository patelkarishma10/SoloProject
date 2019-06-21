package com.bae.business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.CharacterRepository;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceImplTest {
	@InjectMocks
	private CharacterServiceImpl service;

	@Mock
	private CharacterRepository repo;

	@Before
	public void setUp() {
		// nothing to set up before tests
	}

	@Test
	public void getAllCharactersTest() {
		Mockito.when(repo.getAllCharacters()).thenReturn(Constants.MOCK_CHARACTER_ARRAY);
		assertEquals(Constants.MOCK_CHARACTER_ARRAY, service.getAllCharacters());
	}

	@Test
	public void createCharacterTest() {
		Mockito.when(repo.createCharacter(Constants.MOCK_CHARACTER_OBJECT)).thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, service.createCharacter(Constants.MOCK_CHARACTER_OBJECT));

	}

	@Test
	public void deleteCharacterTest() {
		Mockito.when(repo.deleteCharacter(1)).thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, service.deleteCharacter(1));

	}

	@Test
	public void updateCharacterDetailsTest() {
		String characterString = Constants.MOCK_CHARACTER_OBJECT;
		Mockito.when(repo.updateCharacterDetails(1, characterString)).thenReturn(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, service.updateCharacterDetails(1, characterString));

	}
}
