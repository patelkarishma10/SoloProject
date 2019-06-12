package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository repo;

	// C
	@Override
	public String createUser(String user) {
		return repo.createUser(user);
	}

	// R
	@Override
	public String getAUser(int id) {
		return repo.getAUser(id);
	}

	// U
	@Override
	public String updateUser(int id, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	// D
	@Override
	public String deleteUser(int id) {
		return repo.deleteUser(id);
	}

}
