package be.xplore.order;

import be.xplore.order.domain.Cookie;
import be.xplore.order.domain.Order;
import be.xplore.order.domain.OrderLine;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Order> createDummyData() {
        return List.of(
                new Order(
                        1,
                        Set.of(new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/1", Cookie.class),
                                        20
                                ),
                                new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/2", Cookie.class),
                                        5
                                )
                        )),
                new Order(2,
                        Set.of(
                                new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/1", Cookie.class),
                                        12
                                ),
                                new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/3", Cookie.class),
                                        6
                                ),
                                new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/4", Cookie.class),
                                        15
                                )
                        )),
                new Order(3,
                        Set.of(new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/1", Cookie.class),
                                        4
                                ),
                                new OrderLine(
                                        restTemplate.getForObject("http://cookieService/cookies/4", Cookie.class),
                                        16
                                )
                        )));
    }

    @GetMapping
    List<Order> getAllOrders() {
        return createDummyData();
    }

    @GetMapping("/{id}")
    Order getOrder(@PathVariable("id") Long id) {
        return createDummyData()
                .stream()
                .filter(o -> o.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("order not found"));
    }
}
