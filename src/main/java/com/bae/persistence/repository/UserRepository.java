package com.bae.persistence.repository;

public interface UserRepository {

	// C
	String createUser(String user);

	// R

	String getAUser(int id);

	// U
	String updateUserDetails(int id, String user);

	// D
	String deleteUser(int id);

}
