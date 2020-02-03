package be.xplore.order.domain;

import be.xplore.order.domain.Cookie;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderLine {
    private Cookie cookie;
    private Integer amount;

    public OrderLine(Cookie cookie, Integer amount) {
        this.cookie = cookie;
        this.amount = amount;
    }
}
