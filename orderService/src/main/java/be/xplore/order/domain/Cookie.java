package be.xplore.order.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cookie {
    private Long id;
    private String brand;
    private double calories;

    public Cookie(Long id, String brand, double calories) {
        this.id = id;
        this.brand = brand;
        this.calories = calories;
    }

    public Cookie() {
    }
}
