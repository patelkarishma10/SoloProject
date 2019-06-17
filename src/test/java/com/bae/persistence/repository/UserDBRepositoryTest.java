package com.bae.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
	private static final String MOCK_DATA_ARRAY = "[{\"id\":1,\"username\":\"user1\",\"password\":\"pass1\",\"email\":\"user1@gmail.com\",\"films\":[{\"id\":4,\"title\":\"lohk\"}]}]";
	private static final String MOCK_DATA_ARRAY2 = "[{\"id\":1,\"username\":\"user1\",\"password\":\"pass1\",\"email\":\"user1@gmail.com\",\"films\":[{}]}]";

	private static final String MOCK_OBJECT = "{\"id\":1,\"username\":\"user1\",\"password\":\"pass1\",\"email\":\"user1@gmail.com\",\"films\":[{\"id\":4,\"title\":\"lohk\"}]}";
	private static final String MOCK_OBJECT2 = "{\"id\":1,\"username\":\"user1\",\"password\":\"pass1\",\"email\":\"user1@gmail.com\",\"films\":[{}]}";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testCreateUserWithFilms() {
		String reply = repo.createUser(MOCK_OBJECT);
		Assert.assertEquals(reply, MOCK_OBJECT);
	}

	@Test
	public void testCreateUserWithoutFilms() {
		//
		// Set<Film> newList = new HashSet<>();
		// Film film = new Film(4, "lohk");
		// newList.add(film);
		//
		// ArrayList<User> userList = new ArrayList<>();
		// User user = new User(4, "kihj", "yd", "jhg", newList);
		// userList.add(user);
		//
		// System.out.println(util.getJSONForObject(userList));

		String reply = repo.createUser(MOCK_OBJECT);
		Assert.assertEquals(reply, MOCK_OBJECT);
	}

	@Test
	public void testDeleteUser() {
		String reply = repo.deleteUser(1);
		Assert.assertEquals(reply, "{\"message\": \"user has been sucessfully deleted\"}");

	}
}
