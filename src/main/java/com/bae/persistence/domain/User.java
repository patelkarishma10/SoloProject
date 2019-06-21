package com.bae.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, unique = true)
	private String username;
	@Column(length = 50)
	private String password;
	@Column(length = 200)
	private String email;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_film", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
	private Set<Film> films = new HashSet<>();

	public User(int id, String username, String password, String email, Set<Film> films) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.films = films;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Film> getFilm() {
		return films;
	}

	public void setFilm(Set<Film> films) {
		this.films = films;
	}

}
