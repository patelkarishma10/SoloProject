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

import com.bae.persistence.repository.FilmDBRepository;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceImplTest {

	@InjectMocks
	private FilmServiceImpl service;

	@Mock
	private FilmDBRepository repo;

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
	public void getAllFilmsTest() {
		Mockito.when(repo.getAllFilms()).thenReturn(Constants.MOCK_FILM_ARRAY);

		Assert.assertEquals(Constants.MOCK_FILM_ARRAY, service.getAllFilms());

	}

}
