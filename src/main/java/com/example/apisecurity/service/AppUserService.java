package com.example.apisecurity.service;

import com.example.apisecurity.domain.AppUser;
import com.example.apisecurity.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getAppUsers();
}
