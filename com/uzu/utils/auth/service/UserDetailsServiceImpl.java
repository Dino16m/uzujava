package com.uzu.utils.auth.service;

import com.uzu.inventory.app.db.repos.UserRepository;
import com.uzu.utils.auth.models.AuthRole;
import com.uzu.utils.auth.models.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Qualifier("UserDetailsServiceImpl")
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        AuthUser authUser = userRepository.findUserByEmail(username);
        if (authUser == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (AuthRole role : authUser.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new org.springframework.security.core.userdetails.User(authUser.getUsername(), authUser.getPassword(), grantedAuthorities);
    }
}
