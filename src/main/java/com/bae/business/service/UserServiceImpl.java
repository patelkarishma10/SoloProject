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

		if (repo.getAUser(id) == null) {
			return "{\"message\": \"This id is not recognised\"}";
		} else {
			return repo.getAUser(id);
		}
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
	public String addFavouriteFilm(int userId, int filmId) {
		return repo.addFavouriteFilm(userId, filmId);
	}

	@Override
	public String deleteFavouriteFilm(int userId, int filmId) {
		return repo.deleteFavouriteFilm(userId, filmId);
	}

}
