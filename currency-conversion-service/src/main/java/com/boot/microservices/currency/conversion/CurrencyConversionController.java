package com.boot.microservices.currency.conversion;

import com.boot.microservices.currency.conversion.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionFeignProxy currencyConversionFeignProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}")
    public CurrencyConversion getConversion(@RequestParam BigDecimal quantity, @PathVariable String from, @PathVariable String to) {

        CurrencyConversion body = currencyConversionFeignProxy.getExchangeValue(from, to);

        return new CurrencyConversion(1l, body.getFrom(), body.getTo(), quantity, body.getConversionFactor(), quantity.multiply(body.getConversionFactor()), body.getPort());

    }
}
