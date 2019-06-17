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
	public String updateUserDetails(int id, String user) {
		return repo.updateUserDetails(id, user);
	}

	// D
	@Override
	public String deleteUser(int id) {
		return repo.deleteUser(id);
	}

	@Override
	public String addFavouriteFilm(int user_id, int film_id) {
		return repo.addFavouriteFilm(user_id, film_id);
	}

}
