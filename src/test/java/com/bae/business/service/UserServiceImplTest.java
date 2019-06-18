package com.bae.business.service;

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

import com.bae.persistence.repository.UserDBRepository;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	@Before
	public void setUp() {
		repo.setManager(manager);
	}

	@Test
	public void getAUserTest() {
		Mockito.when(service.getAUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, repo.getAUser(1));

	}

	@Test
	public void createUserTest() {
		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(service.createUser(userString)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, repo.createUser(userString));

	}

	@Test
	public void deleteUserTest() {
		Mockito.when(service.deleteUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, repo.deleteUser(1));

	}

	@Test
	public void updateUserDetailsTest() {

		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(service.updateUserDetails(1, userString)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, repo.updateUserDetails(1, userString));

	}

	@Test
	public void addFavouriteFilmTest() {
		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(service.addFavouriteFilm(1, 2)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, repo.addFavouriteFilm(1, 2));

	}

}
