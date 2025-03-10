package ntu.dp.torholskyi.librarymanager.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class CurrencyService {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5"; // API для курсу валют

    public String getCurrencyRates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        return response.getBody();
    }
}