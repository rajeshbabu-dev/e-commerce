package com.ecommerce.repository;

import com.ecommerce.enums.OrderStatus;
import com.ecommerce.model.Order;
import com.ecommerce.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private final List<Order> orders;

    public OrderRepository() throws IOException {
        CsvParser csvParser = new CsvParser();
        this.orders = csvParser.getOrdersFromCsv();
    }

    // find all
    public List<Order> findAll() {
        return orders;
    }

    // find by id
    public Optional<Order> findById(int id) {
        return orders.stream()
                .filter(O -> O.getId() == id)
                .findFirst();
    }

    //Save
    public Order save(Order order) {
        this.orders.add(order);
        return order;
    }

    // Update
    public Optional<Order> update(int id, OrderStatus newStatus) {
        return this.orders.stream()
                .filter(O -> O.getId() == id)
                .findFirst().map(order1 -> {
                    order1.setStatus(newStatus);
                    return order1;
                } );
    }

    // Delete
    public boolean delete(int id) {
        return this.orders.removeIf(order -> order.getId() == id);
    }
}
