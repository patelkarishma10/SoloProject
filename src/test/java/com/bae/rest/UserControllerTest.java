package com.bae.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.UserService;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController controller;

	@Mock
	private UserService service;

	@Before
	public void setup() {
		controller.setService(service);

	}

	@Test
	public void getAUserTest() {
		Mockito.when(service.getAUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.getAUser(1));
	}

	@Test
	public void createUserTest() {
		Mockito.when(service.createUser(Constants.MOCK_USER_OBJECT)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.createUser(Constants.MOCK_USER_OBJECT));

	}

	@Test
	public void deleteUserTest() {
		Mockito.when(service.deleteUser(1)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.deleteUser(1));

	}

	@Test
	public void updateUserDetailsTest() {
		String userString = Constants.MOCK_USER_OBJECT;
		Mockito.when(service.updateUserDetails(1, userString)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.updateUserDetails(1, userString));

	}

	@Test
	public void addFavouriteFilmTest() {
		Mockito.when(service.addFavouriteFilm(1, 2)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.addFavouriteFilm(1, 2));

	}

	@Test
	public void deleteFavouriteFilmTest() {
		Mockito.when(service.deleteFavouriteFilm(1, 2)).thenReturn(Constants.MOCK_USER_OBJECT);
		Assert.assertEquals(Constants.MOCK_USER_OBJECT, controller.deleteFavouriteFilm(1, 2));

	}
}
