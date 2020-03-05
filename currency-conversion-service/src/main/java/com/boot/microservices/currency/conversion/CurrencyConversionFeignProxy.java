package com.boot.microservices.currency.conversion;

import com.boot.microservices.currency.conversion.bean.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyConversionFeignProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
