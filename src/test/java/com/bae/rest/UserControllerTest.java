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
}
