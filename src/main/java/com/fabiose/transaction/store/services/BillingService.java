package com.fabiose.transaction.store.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiose.transaction.store.domains.Billing;
import com.fabiose.transaction.store.domains.Sell;
import com.fabiose.transaction.store.repositories.BillingRepository;
import com.fabiose.transaction.store.utils.DataBaseUtil;

import cieloecommerce.sdk.ecommerce.Sale;

@Service
public class BillingService {
	
	@Autowired
	private BillingRepository billingRepository;
	
	public void save(EntityManager em, Billing billing) throws Exception{
		billingRepository.save(em, billing);
	}
	
	public Billing build(EntityManager em, Sell sell, Sale sale) throws Exception{
		Billing billing = new Billing();
		
		BigInteger idBilling = DataBaseUtil.getSequence(em, "public.billing_id_seq");
		billing.setId(idBilling.longValue());
		billing.setAmount(new BigDecimal(sale.getPayment().getAmount()));
		billing.setProofSale(sale.getPayment().getProofOfSale());
		billing.setPayment(sale.getPayment().getPaymentId());
		billing.setTransaction(sale.getPayment().getTid());
		billing.setAuthorization(sale.getPayment().getAuthorizationCode());
		billing.setSell(sell);		
		billing.setDate(LocalDateTime.now());
		
		return billing;
	}
	
}
