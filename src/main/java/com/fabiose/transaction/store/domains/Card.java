package com.fabiose.transaction.store.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
	
	private String number;
	private String code;
	private String customer;
	private String bank;
	private String expiration;
	
}
