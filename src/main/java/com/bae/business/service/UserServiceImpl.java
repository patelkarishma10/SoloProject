package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository repo;

	// C

	// R
	@Override
	public String getAUser(int id) {
		return repo.getAUser(id);
	}

	// U

	// D

}