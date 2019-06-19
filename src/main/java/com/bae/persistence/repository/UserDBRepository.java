package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Film;
import com.bae.persistence.domain.User;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAUser(int id) {

		User userFound = em.find(User.class, id);
		return json.getJSONForObject(userFound);

	}

	@Transactional(REQUIRED)
	@Override
	public String createUser(String user) {

		User userCreated = this.json.getObjectForJSON(user, User.class);
		em.persist(userCreated);
		return json.getJSONForObject(userCreated);
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteUser(int id) {
		User userFound = em.find(User.class, id);
		em.remove(userFound);
		return "{\"message\": \"user has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateUserDetails(int id, String user) {
		User userCreated = this.json.getObjectForJSON(user, User.class);
		Query q1 = em.createQuery(
				String.format("UPDATE User u SET u.username = '%s', u.password = '%s', u.email = '%s' WHERE u.id = %s",
						userCreated.getUsername(), userCreated.getPassword(), userCreated.getEmail(), id));
		q1.executeUpdate();
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String addFavouriteFilm(int userId, int filmId) {
		Query q2 = em.createNativeQuery(
				String.format("INSERT INTO User_Film(USER_id, FILM_id) VALUES (%s,%s)", userId, filmId));

		q2.executeUpdate();
		return "{\"message\": \"film has been sucessfully added to favourite films\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteFavouriteFilm(int userId, int filmId) {
		User user = em.find(User.class, userId);
		for (Film film : user.getFilm()) {
			if (film.getId() == filmId) {
				user.getFilm().remove(film);
				break;
			}
		}
		return "{\"message\": \"film has been sucessfully removed from favourite films\"}";
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	public void setUtil(JSONUtil util) {
		this.json = util;
	}

}
