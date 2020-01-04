package com.pro.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pro.app.CurrExchServProxy;
import com.pro.app.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrExchServProxy currExchServProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		ResponseEntity<CurrencyConversion> currencyConversionRespEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,from,to);
		
		CurrencyConversion currencyConversionResponse = currencyConversionRespEntity.getBody();
		
		return new CurrencyConversion(currencyConversionResponse.getId(), from, to, currencyConversionResponse.getConversionMultiple(), 
				quantity,quantity.multiply(currencyConversionResponse.getConversionMultiple()), currencyConversionResponse.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		CurrencyConversion currencyConversionResponse = currExchServProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversionResponse.getId(), from, to, currencyConversionResponse.getConversionMultiple(), 
				quantity,quantity.multiply(currencyConversionResponse.getConversionMultiple()), currencyConversionResponse.getPort());
	}
}
