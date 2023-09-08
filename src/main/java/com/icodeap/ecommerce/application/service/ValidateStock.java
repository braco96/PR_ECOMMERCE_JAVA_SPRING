package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.Stock;

import java.util.List;

public class ValidateStock {
    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }

    private boolean existBalance(Product product){
        List<Stock> stockList = stockService.getStockByProduct(product);
        return stockList.isEmpty() ? false : true;
    }

    public Stock calculateBalance(Stock stock) {
        List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
        int balance = stockList.isEmpty() ? 0 : stockList.get(stockList.size() - 1).getBalance();

        if (stock.getUnitIn() != 0) {
            stock.setBalance(balance + stock.getUnitIn());
        } else {
            stock.setBalance(balance - stock.getUnitOut());
        }

        return stock;
    }

}

