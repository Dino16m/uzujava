package com.uzu.utils.auth.models;


import java.util.Set;

public interface AuthRole {
    public Long getId();
    public String getName();
    public void setName(String name);
    public Set<? extends AuthUser> getUsers();
    public void setUsers(Set<? extends AuthUser> users);

}
