package com.bae.business.service;

public interface UserService {

	// C
	String createUser(String user);

	// R
	String getAUser(int id);

	// U
	String updateUser(int id, String user);

	// D
	String deleteUser(int id);
}
