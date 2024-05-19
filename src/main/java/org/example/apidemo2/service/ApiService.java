package org.example.apidemo2.service;

import org.example.apidemo2.apiRespository.ArticleRepository;
import org.example.apidemo2.model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final String API_KEY = "gnRpWLDOtlL3sOGKnhXNRx4Tqny9cxNR";
    public final ArticleRepository articleRepository;

    public ApiService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public String getData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=" + API_KEY;
            return restTemplate.getForObject(apiUrl, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "Data could not be retrieved from the API.";
        }
    }

    public String getHeadline() {
        String responseData = getData();
        if (responseData.equals("Data could not be retrieved from the API.")) {
            return responseData;
        }

        try {
            JSONObject jsonResponse = new JSONObject(responseData);
            JSONArray docsArray = jsonResponse.getJSONObject("response").getJSONArray("docs");

            for (int i = 0; i < docsArray.length(); i++) {
                JSONObject doc = docsArray.getJSONObject(i);
                String webUrl = doc.getString("web_url");
                JSONObject headline = doc.getJSONObject("headline");
                String mainHeadline = headline.getString("main");

                Article article = new Article();
                article.setWebUrl(webUrl);
                article.setHeadline(mainHeadline);
                articleRepository.save(article);
            }

            return "Data saved successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while processing the data.";
        }
    }

}
