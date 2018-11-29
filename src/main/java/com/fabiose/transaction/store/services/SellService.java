package com.fabiose.transaction.store.services;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiose.transaction.store.domains.Billing;
import com.fabiose.transaction.store.domains.Sell;
import com.fabiose.transaction.store.enums.LogEnum;
import com.fabiose.transaction.store.repositories.SellRepository;
import com.fabiose.transaction.store.utils.ConstantUtil;
import com.fabiose.transaction.store.utils.DataBaseUtil;
import com.fabiose.transaction.store.utils.LogUtil;

import cieloecommerce.sdk.ecommerce.Sale;
import cieloecommerce.sdk.ecommerce.request.CieloRequestException;

@Service
public class SellService {

	@Autowired
	private SellRepository sellRepository;

	@Autowired
	private BillingService billingService;

	@Autowired
	private PayService payService;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public void save(Sell sell) throws Exception {

		EntityManager em = entityManagerFactory.createEntityManager();

		try {

			em.getTransaction().begin();
			
			BigInteger idSell = DataBaseUtil.getSequence(em, "public.sell_id_seq");
			sell.setId(idSell.longValue());
			sell.setNumber(String.valueOf(System.currentTimeMillis()));
			
			LogUtil.write(ConstantUtil.STARTING_TRANSACTION.concat(" to sell id ["+ sell.getId() +"]"), LogEnum.DEBUG);			

			LogUtil.write("Waiting for payment authorization from credit card to sell id [" + sell.getId() + "] ...",
					LogEnum.DEBUG);
			Sale sale = payService.doPayment(sell);
			LogUtil.write("Authorized payment to sell id [" + idSell + "] ...", LogEnum.DEBUG);

			sell.setDate(LocalDateTime.now());

			LogUtil.write("Registering sell id [" + idSell + "] in database ...", LogEnum.DEBUG);
			sellRepository.save(em, sell);

			Billing billing = billingService.build(em, sell, sale);
			LogUtil.write("Registering billing id [" + billing.getId() + "] in database ...", LogEnum.DEBUG);

			billingService.save(em, billing);

			em.getTransaction().commit();

			LogUtil.write(ConstantUtil.TRANSACTION_COMPLETED.concat(" to sell id ["+ sell.getId() +"]"), LogEnum.DEBUG);

		} catch (CieloRequestException e) {
			em.getTransaction().rollback();

			LogUtil.write(e.getError().getMessage(), LogEnum.ERROR);
			LogUtil.write(ConstantUtil.TRANSACTION_ABORTED, LogEnum.DEBUG);

			throw new CieloRequestException(e.getError().getMessage(), null, null);
		} catch (Exception e) {
			em.getTransaction().rollback();

			LogUtil.write(e.getCause().toString(), LogEnum.ERROR);
			LogUtil.write(ConstantUtil.TRANSACTION_ABORTED, LogEnum.DEBUG);

			throw new Exception(e.getMessage());
		}

	}

}
