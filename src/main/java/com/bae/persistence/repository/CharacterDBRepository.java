package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Characters;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CharacterDBRepository implements CharacterRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllCharacters() {
		TypedQuery<Characters> query = em.createQuery("SELECT c FROM Characters c", Characters.class);
		Collection<Characters> characters = query.getResultList();
		return json.getJSONForObject(characters);
	}

}
