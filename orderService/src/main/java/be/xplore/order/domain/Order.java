package be.xplore.order.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class Order {
    public int id;
    private Set<OrderLine> lines;

    public Order(int id, Set<OrderLine> lines) {
        this.id = id;
        this.lines = lines;
    }
}
