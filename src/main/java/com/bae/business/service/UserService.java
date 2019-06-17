package com.bae.business.service;

public interface UserService {

	// C
	String createUser(String user);

	String addFavouriteFilm(int user_id, int film_id);

	// R
	String getAUser(int id);

	// U
	String updateUserDetails(int id, String user);

	// D
	String deleteUser(int id);
}
