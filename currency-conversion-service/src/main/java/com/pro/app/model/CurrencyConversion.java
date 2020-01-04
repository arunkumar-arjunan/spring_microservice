package com.pro.app.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalcualtedAmount;
	private int port;
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalcualtedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalcualtedAmount = totalCalcualtedAmount;
		this.port = port;
	}
	
	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
