package com.arpax.ARPA.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.arpax.ARPA.model.Stock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arpax.ARPA.sevice.StockService;

@RestController
@RequestMapping("/api")
public class StockController {

	private StockService stockService;

	public StockController(StockService stockService) {
		this.stockService = stockService;
	}

	@RequestMapping(value = "stock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getAllStocks() {
		return stockService.findAll();
	}

	@RequestMapping(value = "stock", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock) throws URISyntaxException {
		try {
			String formattedDate = this.datePattern();
			stock.setCreatedDate(formattedDate);
			stock.setModifiedDate(formattedDate);
			Stock result = stockService.save(stock);
			return ResponseEntity.created(new URI("/api/stock/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Stock>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "stock", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) throws URISyntaxException {
		if (stock.getId() == null) {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
		}

		try {
			String formattedDate = this.datePattern();
			stock.setModifiedDate(formattedDate);
			Stock result = stockService.update(stock);

			return ResponseEntity.created(new URI("/api/stock/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/stock/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteStock(@PathVariable Integer id) {
		stockService.delete(id);

		return ResponseEntity.ok().build();
	}

	private String datePattern() {

		Date date = new Date();
		String pattern = "dd-MM-yyyy hh:mm:ss";
		SimpleDateFormat simpleFormatter  = new SimpleDateFormat(pattern);
		String formattedDate = simpleFormatter.format(date);

		return formattedDate;
	}
}
