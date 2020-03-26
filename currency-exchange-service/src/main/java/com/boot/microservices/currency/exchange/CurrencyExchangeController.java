package com.boot.microservices.currency.exchange;

import com.boot.microservices.currency.exchange.bean.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CurrencyExchangeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    private ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {

        final ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("Returned ExchangeValue {}", exchangeValue);

        return exchangeValue;
    }
}
