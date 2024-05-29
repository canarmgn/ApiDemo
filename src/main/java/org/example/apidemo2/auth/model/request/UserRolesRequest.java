package org.example.apidemo2.auth.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRolesRequest {

    private long userId;
    private long roleId;


    public UserRolesRequest(long userId, long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }


}



