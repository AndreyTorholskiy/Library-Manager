package ntu.dp.torholskyi.librarymanager.controller;

import ntu.dp.torholskyi.librarymanager.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/api/currency")
    public String getCurrencyRates() {
        return currencyService.getCurrencyRates();
    }
}
