package com.bae.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
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

		Assert.assertEquals(2, u2.getId());
		Assert.assertEquals("testUsername", u2.getUsername());
		Assert.assertEquals("TestEmail", u2.getEmail());
		Assert.assertEquals("testPassword", u2.getPassword());

	}

}
