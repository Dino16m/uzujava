package com.uzu.utils.auth.models;


import java.util.Set;

public interface AuthUser {
    public  void setPassword(String password);
    public String getUsername();
    public void setRoles(Set<? extends AuthRole> roles);
    public Set<? extends AuthRole> getRoles();
    public String getPassword();
}
