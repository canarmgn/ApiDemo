package org.example.apidemo2.auth.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;
    private String roleName;

    public AuthRequest(String username, String password, String roleName) {
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }
}
