package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Film;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class FilmDBRepositoryTest {

	@InjectMocks
	private FilmDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;

	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"id\":1,\"title\":\"Test Film\"}]";

	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getAllFilmsTest() {
		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn(query);
		List<Object> films = new ArrayList<Object>();
		films.add(new Film(1, "Test Film"));
		Mockito.when(query.getResultList()).thenReturn(films);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllFilms());
	}
}
