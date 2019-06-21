package com.bae.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UserTest {
	@Test
	public void userTest() {
		Set<Film> filmList = new HashSet<>();
		User u2 = new User(1, "user", "passw", "email", filmList);

		u2.setId(2);
		u2.setUsername("testUsername");
		u2.setEmail("TestEmail");
		u2.setPassword("testPassword");

		assertEquals(2, u2.getId());
		assertEquals("testUsername", u2.getUsername());
		assertEquals("TestEmail", u2.getEmail());
		assertEquals("testPassword", u2.getPassword());

	}

}
