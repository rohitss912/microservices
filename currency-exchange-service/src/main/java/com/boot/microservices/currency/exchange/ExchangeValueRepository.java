package com.boot.microservices.currency.exchange;

import com.boot.microservices.currency.exchange.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
