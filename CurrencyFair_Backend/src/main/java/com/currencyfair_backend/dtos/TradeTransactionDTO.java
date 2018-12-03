package com.currencyfair_backend.dtos;

public class TradeTransactionDTO {

    private String userId;

    private String currencyFrom;

    private String currencyTo;

    private double amountSell;

    private double amountBuy;

    private double rate;

    private String timePlaced;

    private String originatingCountry;

    public TradeTransactionDTO() {
        super();
    }

    public TradeTransactionDTO(final String userId,
                               final String currencyFrom,
                               final String currencyTo,
                               final double amountBuy,
                               final double amountSell,
                               final double rate,
                               final String timePlaced,
                               final String originatingCountry) {
        super();

        this.userId = userId;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amountBuy = amountBuy;
        this.amountSell = amountSell;
        this.rate = rate;
        this.timePlaced = timePlaced;
        this.originatingCountry = originatingCountry;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
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

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }
}
