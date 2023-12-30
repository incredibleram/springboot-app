package com.inm429.ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import com.inm429.ecommerce.Model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
