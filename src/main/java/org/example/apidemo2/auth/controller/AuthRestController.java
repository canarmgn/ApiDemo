package org.example.apidemo2.auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.apidemo2.auth.model.request.AuthRequest;
import org.example.apidemo2.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) {
        return authService.getToken(authRequest);
    }

}