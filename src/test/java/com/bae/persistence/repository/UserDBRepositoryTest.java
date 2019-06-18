package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Film;
import com.bae.persistence.domain.User;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDBRepositoryTest {

	@InjectMocks
	private UserDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testCreateUserWithFilms() {
		String reply = repo.createUser(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(reply, Constants.MOCK_USER_OBJECT);
	}

	@Test
	public void testDeleteUser() {
		String reply = repo.deleteUser(1);
		Assert.assertEquals(reply, "{\"message\": \"user has been sucessfully deleted\"}");

	}

	@Test
	public void getAUserTest() {

		List<User> users = new ArrayList<User>();
		Set<Film> newList = new HashSet<>();

		User user = new User(1, "kihj", "yd", "jhg", newList);

		Mockito.when(manager.find(User.class, 1)).thenReturn(user);

		Assert.assertEquals(util.getJSONForObject(user), repo.getAUser(1));

	}

	@Test
	public void updateUserTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		Set<Film> newList = new HashSet<>();
		User user = new User(1, "kihj", "yd", "jhg", newList);
		Mockito.when(query.getResultList()).thenReturn(users);
		String reply = repo.updateUserDetails(1, util.getJSONForObject(user));
		Assert.assertEquals(reply, "{\"message\": \"account has been sucessfully updated\"}");
	}

	@Test
	public void addFavouriteFilmTest() {
		Mockito.when(manager.createNativeQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		Set<Film> newList = new HashSet<>();
		Film film = new Film(1, "TestFilm");
		User user = new User(1, "kihj", "yd", "jhg", newList);
		Mockito.when(query.getResultList()).thenReturn(users);
		String reply = repo.addFavouriteFilm(1, 1);
		Assert.assertEquals(reply, "{\"message\": \"film has been sucessfully added to favourite films\"}");
	}

}
