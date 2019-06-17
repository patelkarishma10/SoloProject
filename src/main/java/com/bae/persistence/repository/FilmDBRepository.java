package com.bae.persistence.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bae.persistence.domain.Film;
import com.bae.util.JSONUtil;

public class FilmDBRepository implements FilmRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllFilms() {
		TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f", Film.class);
		Collection<Film> films = query.getResultList();
		return json.getJSONForObject(films);
	}

}
