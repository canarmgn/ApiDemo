package org.example.apidemo2.controller;

import org.example.apidemo2.apiRespository.ArticleRepository;
import org.example.apidemo2.model.Article;
import org.example.apidemo2.service.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/getapidata")
    public String getData() {
        String responseData = apiService.getData();
        if (responseData.equals("API'den veri alınamadı.")) {
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

            return "Veriler başarıyla kaydedildi.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Veri işlenirken bir hata oluştu.";
        }
    }
}
