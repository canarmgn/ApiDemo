package org.example.apidemo2.auth.model.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest() {

    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
