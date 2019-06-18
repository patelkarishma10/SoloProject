package com.bae.rest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.UserService;

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

}
