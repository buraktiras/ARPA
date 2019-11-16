package com.arpax.ARPA.resource;

import com.arpax.ARPA.model.Stock;
import com.arpax.ARPA.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/stocks")
public class StocksAPIResource {

    @Autowired
    StockRepository stockRepository;

    @GetMapping(value = "/allStocks")
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }




}
