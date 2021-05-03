package com.example.stocksapplication.controllers;

import com.example.stocksapplication.repositories.StockRepository;
import com.example.stocksapplication.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class StockController {

    private final StockRepository stockDao;
    private final UserRepository userDao;

    public StockController(StockRepository stockDao, UserRepository userDao) {
        this.stockDao = stockDao;
        this.userDao = userDao;
    }



}
