package com.bae.business.service;

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

	@Before
	public void setUp() {

	}

	@Test
	public void getAUserTest() {
		Mockito.when(repo.getAUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, service.getAUser(1));

	}

	@Test
	public void createUserTest() {
		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(repo.createUser(userString)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, service.createUser(userString));
	}

	@Test
	public void deleteUserTest() {
		Mockito.when(repo.deleteUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, service.deleteUser(1));

	}

	@Test
	public void updateUserDetailsTest() {

		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(repo.updateUserDetails(1, userString)).thenReturn(Constants.MOCK_USER_OBJECT);

		Assert.assertEquals(Constants.MOCK_USER_OBJECT, service.updateUserDetails(1, userString));

	}

	@Test
	public void addFavouriteFilmTest() {
		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(repo.addFavouriteFilm(1, 2)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, service.addFavouriteFilm(1, 2));

	}

}
