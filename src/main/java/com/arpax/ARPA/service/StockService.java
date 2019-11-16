package com.arpax.ARPA.service;

import com.arpax.ARPA.model.Stock;
import com.arpax.ARPA.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StockService {
	private StockRepository stockRepository;

	@Autowired
	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	public Stock save(Stock stock) {
		if (stock.getId() != null && stockRepository.existsById(stock.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return stockRepository.save(stock);
	}

	public Stock update(Stock stock) {
		if (stock.getId() != null && !stockRepository.existsById(stock.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return stockRepository.save(stock);
	}

	public List<Stock> findAll() {
		return stockRepository.findAll();
	}

	public Stock findOne(Integer id) {
		return stockRepository.findById(id).orElse(new Stock());
	}

	public void delete(Integer id) {
		stockRepository.deleteById(id);
	}
}
