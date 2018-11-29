package com.fabiose.transaction.store.utils;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DataBaseUtil {

	public static BigInteger getSequence(EntityManager em, String seq) throws Exception {

		Query query = em.createNativeQuery("SELECT nextval( '" + seq + "' )");

		return (BigInteger) query.getSingleResult();
		
	}

}