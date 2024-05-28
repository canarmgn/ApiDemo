package org.example.apidemo2.controller;

import lombok.RequiredArgsConstructor;
import org.example.apidemo2.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/getapidata")
    @PreAuthorize("hasRole('ROLE_EDITOR')")
    public String getData() {
        return apiService.getHeadline();
    }


}
