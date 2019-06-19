package com.bae.business.service;

public interface UserService {

	// C
	String createUser(String user);

	String addFavouriteFilm(int userId, int filmId);

	// R
	String getAUser(int id);

	// U
	String updateUserDetails(int id, String user);

	// D
	String deleteUser(int id);

	String deleteFavouriteFilm(int userId, int filmId);
}
