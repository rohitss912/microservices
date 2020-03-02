package com.boot.microservices.currency.exchange.bean;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigInteger conversionFactor;

    @Transient
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigInteger conversionFactor) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getConversionFactor() {
        return conversionFactor;
    }
}
