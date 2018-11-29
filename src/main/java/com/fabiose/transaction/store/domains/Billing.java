package com.fabiose.transaction.store.domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="billing")
@Getter
@Setter
public class Billing implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name="amount")
	private BigDecimal  amount;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="transaction_code")
	private String transaction;
	
	@Column(name="proof_sale_code")
	private String proofSale;
	
	@Column(name="authorization_code")
	private String authorization;
	
	@Column(name="payment_code")
	private String payment;
	
	@OneToOne
	@JoinColumn(name = "id_sell")
	private Sell sell;
	
}
