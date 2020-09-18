package com.mylearningapp.own.security.securityController;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FacebookUser {

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String accessToken;

    private String id;
}
