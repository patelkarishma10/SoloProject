package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.FilmRepository;

public class FilmServiceImpl implements FilmService {

	@Inject
	private FilmRepository repo;

	@Override
	public String getAllFilms() {
		return repo.getAllFilms();
	}

}
