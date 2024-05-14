package org.example.apidemo2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {


    private static final String APİ_KEY = "gnRpWLDOtlL3sOGKnhXNRx4Tqny9cxNR";

    public String getData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=" + APİ_KEY;
            String response = restTemplate.getForObject(apiUrl, String.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return "API'den veri alınamadı.";
        }
    }
}
