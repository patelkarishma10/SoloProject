package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		return "{\"message\": \"user has been sucessfully created\"}";
	}

}
