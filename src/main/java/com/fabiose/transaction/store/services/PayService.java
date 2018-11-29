package com.fabiose.transaction.store.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fabiose.transaction.store.domains.Sell;

import cieloecommerce.sdk.Merchant;
import cieloecommerce.sdk.ecommerce.CieloEcommerce;
import cieloecommerce.sdk.ecommerce.Environment;
import cieloecommerce.sdk.ecommerce.Payment;
import cieloecommerce.sdk.ecommerce.Sale;
import cieloecommerce.sdk.ecommerce.request.CieloRequestException;

@Service
public class PayService {

	@Value("${merchant_id}")
	private String merchantId;

	@Value("${merchant_key}")
	private String merchantKey;

	public Sale doPayment(Sell sell) throws CieloRequestException, Exception {
		Merchant merchant = new Merchant(merchantId, merchantKey);
		
		Sale sale = new Sale(sell.getNumber());

		Payment payment = sale.payment(sell.getPrice().intValue());
		
		payment.creditCard(sell.getCard().getCode(), sell.getCard().getBank())
		.setExpirationDate(sell.getCard().getExpiration())
		.setCardNumber(sell.getCard().getNumber())
		.setHolder(sell.getCard().getCustomer());
		
		return new CieloEcommerce(merchant, Environment.SANDBOX).createSale(sale);
		
	}
}
