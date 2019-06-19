package com.bae.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.FilmService;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class FilmControllerTest {

	@InjectMocks
	private FilmController controller;

	@Mock
	private FilmService service;

	@Before
	public void setup() {
		controller.setService(service);
	}

	@Test
	public void getAllFilmsTest() {
		Mockito.when(service.getAllFilms()).thenReturn(Constants.MOCK_FILM_ARRAY);
		Assert.assertEquals(Constants.MOCK_FILM_ARRAY, controller.getAllFilms());
	}

}
