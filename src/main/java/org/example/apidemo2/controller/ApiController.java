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
        return apiService.getHeadline();
    }
}
