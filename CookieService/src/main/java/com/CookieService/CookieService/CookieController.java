package com.CookieService.CookieService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cookies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CookieController {
    private final CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping
    List<Cookie> getCookie() {
        return cookieService.getAllCookies();
    }

    @GetMapping("/{id}")
    Cookie getCookie(@PathVariable("id") Long id) {
        return cookieService.getCookie(id);
    }

}
