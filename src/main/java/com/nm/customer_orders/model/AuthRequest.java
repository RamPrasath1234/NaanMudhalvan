package com.nm.customer_orders.model;

import lombok.*;

/**
 * @author Teja K
 */



@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

