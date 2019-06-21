package com.bae.business.service;

import static org.junit.Assert.assertEquals;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.FilmRepository;
import com.bae.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceImplTest {

	@InjectMocks
	private FilmServiceImpl service;

	@Mock
	private FilmRepository repo;

	@Mock
	private Query query;

	@Before
	public void setUp() {
		// nothing to set up before tests
	}

	@Test
	public void getAllFilmsTest() {
		Mockito.when(repo.getAllFilms()).thenReturn(Constants.MOCK_FILM_ARRAY);
		assertEquals(Constants.MOCK_FILM_ARRAY, service.getAllFilms());

	}

}
