package com.fabiose.transaction.store.repositories;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fabiose.transaction.store.domains.Sell;

@Repository
public class SellRepository {

	public void save(EntityManager em, Sell sell) throws Exception {
		em.persist(sell);
	}

}
