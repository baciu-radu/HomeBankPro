package com.ing.hubs.services;

import com.ing.hubs.models.ExchangeRateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6";
    private static final String API_KEY = "00aea25fed8bb9c4c3f9ebc4";

    private final RestTemplate restTemplate;

    public ExchangeRateService() {
        this.restTemplate = new RestTemplate();
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        String url = String.format("%s/%s/pair/%s/%s", API_BASE_URL, API_KEY, baseCurrency, targetCurrency);
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        if (response != null && response.getResult().equals("success")) {
            return response.getConversion_rate();
        }
        throw new RuntimeException("Failed to retrieve exchange rate.");
    }
}
