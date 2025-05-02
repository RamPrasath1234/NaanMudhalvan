package com.nm.customer_orders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Teja K
 */

@Getter
@Setter
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}

