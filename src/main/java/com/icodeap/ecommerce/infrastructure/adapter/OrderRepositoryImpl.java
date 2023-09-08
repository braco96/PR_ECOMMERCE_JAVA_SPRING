package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.OrderRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.infrastructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder( orderCrudRepository.save( orderMapper.toOrderEntity(order) ) );
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders( orderCrudRepository.findAll() );
    }
}
