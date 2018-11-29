package com.fabiose.transaction.store.repositories;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fabiose.transaction.store.domains.Billing;

@Repository
public class BillingRepository {

	public void save(EntityManager em, Billing billing) throws Exception {
		em.persist(billing);
	}

}
