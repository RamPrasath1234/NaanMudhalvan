package com.nm.customer_orders.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotBlank(message = "product name is required")
    //@Column(nullable = false)
    private String product;

    //@NotNull(message = "quantity is required")
    //@Column(nullable = false)
    private int quantity;

    //@NotNull(message = "price is required")
    //@Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    //@JsonIgnore
    @JsonBackReference
    private Customer customer;

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
