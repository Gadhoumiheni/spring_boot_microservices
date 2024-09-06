package com.in28minutes.microservices.currency_exchange_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    private CurrencyExchangeRepository currencyEchangeRepository;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeController(CurrencyExchangeRepository currencyEchangeRepository) {
        this.currencyEchangeRepository = currencyEchangeRepository;
    }

    @Autowired
    private Environment env;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("unable to find data");
        }
        String port= env.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;




    }



}
