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
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sell")
@Getter
@Setter
public class Sell implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name="number")
	private String  number;
	
	@Column(name="price")
	private BigDecimal  price;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@OneToOne
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Transient
	private Card card;
	
}
