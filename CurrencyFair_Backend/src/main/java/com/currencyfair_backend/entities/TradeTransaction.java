package com.currencyfair_backend.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="trade_transaction")
public class TradeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_from")
    private Currency currencyFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_to")
    private Currency currencyTo;

    @Column(name = "amount_sell")
    private double amountSell;

    @Column(name = "amount_buy")
    private double amountBuy;

    @Column(name = "rate")
    private double rate;

    @Column(name = "time_placed")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-YY hh:mm:ss")
    private Date timePlaced;

    @Enumerated(EnumType.STRING)
    @Column(name = "originating_country")
    private Country originatingCountry;


    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(Currency currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(Currency currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(double amountSell) {
        this.amountSell = amountSell;
    }

    public double getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(double amountBuy) {
        this.amountBuy = amountBuy;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public Country getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(Country originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public Long getId() {
        return id;
    }

}
