package com.org.microservices.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.microservices.bean.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retreiveExchangeValue(@PathVariable(name = "from") String from, @PathVariable(name = "to") String to);
}