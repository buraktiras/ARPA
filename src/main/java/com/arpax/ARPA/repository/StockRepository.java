package com.arpax.ARPA.repository;

import com.arpax.ARPA.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	Stock findByName(String name);
}