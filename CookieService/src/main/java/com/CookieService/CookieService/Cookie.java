package com.CookieService.CookieService;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Cookie {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private double calories;

    public Cookie() {
    }

    public Cookie(String brand, double calories) {
        this.brand = brand;
        this.calories = calories;
    }
}