package com.nm.customer_orders.repository;

import com.nm.customer_orders.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
