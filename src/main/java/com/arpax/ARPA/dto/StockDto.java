package com.arpax.ARPA.dto;

import com.arpax.ARPA.model.Stock;

public class StockDto extends Stock {

    private int price;

    public StockDto(int price) {
        this.price = price;
    }

    public StockDto(Stock stock) {
        this.setId(stock.getId());
        this.setCode(stock.getCode());
        this.setName(stock.getName());
        this.setModifiedDate(stock.getModifiedDate());
        this.setCreatedDate(stock.getCreatedDate());
        this.setModifiedBy(stock.getModifiedBy());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
