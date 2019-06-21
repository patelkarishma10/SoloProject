package com.bae.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Characters;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class CharacterDBRepositoryTest {

	@InjectMocks
	private CharacterDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	@Mock
	private TypedQuery<Object> typedQuery;

	private JSONUtil util;

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getAllCharactersTest() {
		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn(typedQuery);
		List<Object> characterList = new ArrayList<>();
		characterList.add(new Characters(1, "Test Character"));
		Mockito.when(typedQuery.getResultList()).thenReturn(characterList);
		assertEquals(util.getJSONForObject(characterList), repo.getAllCharacters());
	}

	@Test
	public void testDeleteCharacter() {
		String reply = repo.deleteCharacter(1);
		assertEquals("{\"message\": \"character has been successfully deleted\"}", reply);

	}

	@Test
	public void testCreateCharacter() {
		String reply = repo.createCharacter(Constants.MOCK_CHARACTER_OBJECT);
		assertEquals(Constants.MOCK_CHARACTER_OBJECT, reply);
	}

	@Test
	public void testUpdateCharacterThatDoesNotExist() {
		String reply = repo.updateCharacterDetails(1, Constants.MOCK_CHARACTER_OBJECT);
		assertEquals("{\"message\": \"character has been successfully updated\"}", reply);
	}

	@Test
	public void testUpdateCharacterThatDoesExist() {
		Characters character = util.getObjectForJSON(Constants.MOCK_CHARACTER_OBJECT, Characters.class);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(character);

		assertEquals("{\"message\": \"character has been successfully updated\"}",
				repo.updateCharacterDetails(1, Constants.MOCK_CHARACTER_OBJECT));

	}
}
