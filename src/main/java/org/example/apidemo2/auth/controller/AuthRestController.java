package org.example.apidemo2.auth.controller;


import lombok.RequiredArgsConstructor;
import org.example.apidemo2.auth.model.UserRoles;
import org.example.apidemo2.auth.model.request.AuthRequest;
import org.example.apidemo2.auth.service.AuthService;
import org.example.apidemo2.auth.service.UserService;
import org.example.apidemo2.model.Article;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) {
        return authService.getToken(authRequest);
    }

    @PostMapping("/adduser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String insertUser(@RequestBody AuthRequest authRequest) {
        userService.createUser(authRequest.getUsername(), authRequest.getPassword());
        return "The user has been successfully registered.";
    }

    @PostMapping("/addrole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addRole(@RequestBody UserRoles userRoles) {
        userService.addRoleToUser(userRoles.getUserId(), userRoles.getRoleId());
        return "The role has been successfully added.";
    }

    @DeleteMapping("/deleteuser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "The user has been successfully deleted.";
    }

    @GetMapping("/daily")
    public List<Article> dailyArticles() {
        return userService.dailyHeadlines();
    }


}