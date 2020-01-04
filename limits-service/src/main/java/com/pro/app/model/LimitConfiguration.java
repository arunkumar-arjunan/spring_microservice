package com.pro.app.model;

import lombok.Data;

@Data
public class LimitConfiguration {
	private int maximum;
	private int minimum;
	
	public LimitConfiguration(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}
}
