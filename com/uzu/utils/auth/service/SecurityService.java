package com.uzu.utils.auth.service;


import javax.servlet.http.HttpServletRequest;

public interface SecurityService {

    public String getAuthUsername();
    boolean autoLogin(String username, String password, HttpServletRequest request);
}
