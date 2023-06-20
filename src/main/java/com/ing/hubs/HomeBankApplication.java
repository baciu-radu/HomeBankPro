package com.ing.hubs;

import com.ing.hubs.models.ExchangeRate;
import com.ing.hubs.repositories.ExchangeRateRepository;
import com.ing.hubs.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class HomeBankApplication implements CommandLineRunner {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;
    @Autowired
    private ExchangeRateService exchangeRateService;

    public static void main(String[] args) {
        SpringApplication.run(HomeBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populating exchange rates...");

        String baseCurrencyEur = "EUR";
        String targetCurrencyRon = "RON";
        double eurToRonExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyEur, targetCurrencyRon);
        ExchangeRate exchangeRate1 = new ExchangeRate(1, baseCurrencyEur, targetCurrencyRon, eurToRonExchangeRate);
        exchangeRateRepository.save(exchangeRate1);

        String baseCurrencyRon = "RON";
        String targetCurrencyEur = "EUR";
        double ronToEurExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyRon, targetCurrencyEur);
        ExchangeRate exchangeRate2 = new ExchangeRate(2, baseCurrencyRon, targetCurrencyEur, ronToEurExchangeRate);
        exchangeRateRepository.save(exchangeRate2);

        ExchangeRate exchangeRate3 = new ExchangeRate(3,"EUR","EUR",1);
        exchangeRateRepository.save(exchangeRate3);

        String targetCurrencyUsd = "USD";
        double eurToUsdExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyEur, targetCurrencyUsd);
        ExchangeRate exchangeRate4 = new ExchangeRate(4, baseCurrencyEur, targetCurrencyUsd, eurToUsdExchangeRate);
        exchangeRateRepository.save(exchangeRate4);

        String targetCurrencyGbp = "GBP";
        double eurToGbpExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyEur, targetCurrencyGbp);
        ExchangeRate exchangeRate5 = new ExchangeRate(5, baseCurrencyEur, targetCurrencyGbp, eurToGbpExchangeRate);
        exchangeRateRepository.save(exchangeRate5);

        double ronToUsdExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyRon, targetCurrencyUsd);
        ExchangeRate exchangeRate6 = new ExchangeRate(6, baseCurrencyRon, targetCurrencyUsd, ronToUsdExchangeRate);
        exchangeRateRepository.save(exchangeRate6);

        double ronToGbpExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyRon, targetCurrencyGbp);
        ExchangeRate exchangeRate7 = new ExchangeRate(7, baseCurrencyRon, targetCurrencyGbp, ronToGbpExchangeRate);
        exchangeRateRepository.save(exchangeRate7);

        ExchangeRate exchangeRate8 = new ExchangeRate(8,"RON","RON",1);
        exchangeRateRepository.save(exchangeRate8);

        String baseCurrencyUsd = "USD";
        double usdToEurExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyUsd, targetCurrencyEur);
        ExchangeRate exchangeRate9 = new ExchangeRate(9, baseCurrencyUsd, targetCurrencyEur, usdToEurExchangeRate);
        exchangeRateRepository.save(exchangeRate9);

        double usdToRonExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyUsd, targetCurrencyRon);
        ExchangeRate exchangeRate10 = new ExchangeRate(10, baseCurrencyUsd, targetCurrencyRon, usdToRonExchangeRate);
        exchangeRateRepository.save(exchangeRate10);

        double usdToGbpExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyUsd, targetCurrencyGbp);
        ExchangeRate exchangeRate11 = new ExchangeRate(11, baseCurrencyUsd, targetCurrencyGbp, usdToGbpExchangeRate);
        exchangeRateRepository.save(exchangeRate11);

        ExchangeRate exchangeRate12 = new ExchangeRate(12,"USD","USD",1);
        exchangeRateRepository.save(exchangeRate12);

        String baseCurrencyGbp = "GBP";
        double gbpToEurExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyGbp, targetCurrencyEur);
        ExchangeRate exchangeRate13 = new ExchangeRate(13, baseCurrencyGbp, targetCurrencyEur, gbpToEurExchangeRate);
        exchangeRateRepository.save(exchangeRate13);

        double gbpToRonExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyGbp, targetCurrencyRon);
        ExchangeRate exchangeRate14 = new ExchangeRate(14, baseCurrencyGbp, targetCurrencyRon, gbpToRonExchangeRate);
        exchangeRateRepository.save(exchangeRate14);

        double gbpToUsdExchangeRate = exchangeRateService.getExchangeRate(baseCurrencyGbp, targetCurrencyUsd);
        ExchangeRate exchangeRate15 = new ExchangeRate(15, baseCurrencyGbp, targetCurrencyUsd, gbpToUsdExchangeRate);
        exchangeRateRepository.save(exchangeRate15);

        ExchangeRate exchangeRate16 = new ExchangeRate(16,"GBP","GBP",1);
        exchangeRateRepository.save(exchangeRate16);
    }
}
