package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
