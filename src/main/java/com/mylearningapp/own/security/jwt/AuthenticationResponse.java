package com.mylearningapp.own.security.jwt;


import com.mylearningapp.own.domain.Role;

public class AuthenticationResponse {
    private String jwt;
    private Long userId;
    private Role role;
    private String name;
    private String email;



    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = email;
    }

    public AuthenticationResponse(String jwt, Long userId, Role role, String name,String email) {
        this.jwt = jwt;
        this.userId = userId;
        this.role = role;
        this.name = name;
        this.email = email;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
