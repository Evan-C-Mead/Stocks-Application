package com.example.stocksapplication.repositories;

import com.example.stocksapplication.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockById(Stock id);
}
