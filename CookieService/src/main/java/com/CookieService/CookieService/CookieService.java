package com.CookieService.CookieService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieService {

    private CookieRepository cookieRepository;

    @Bean
    CommandLineRunner generateTestData() {
        return args -> {
            cookieRepository.save(new Cookie("new-yorkers", 98));
            cookieRepository.save(new Cookie("brownie", 120));
            cookieRepository.save(new Cookie("zandkoek", 20));
            cookieRepository.save(new Cookie("boudoirs", 61));
            cookieRepository.save(new Cookie("leo", 68));
        };
    }

    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    List<Cookie> getAllCookies() {
        return cookieRepository.findAll();
    }

    Cookie getCookie(Long id) {
        return cookieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cookie not found"));
    }
}
