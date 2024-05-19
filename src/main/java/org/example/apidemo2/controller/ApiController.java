package org.example.apidemo2.controller;

import lombok.RequiredArgsConstructor;
import org.example.apidemo2.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/getapidata")
    public String getData() {
        return apiService.getHeadline();
    }


}
