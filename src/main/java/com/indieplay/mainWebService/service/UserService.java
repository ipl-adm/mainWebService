package com.indieplay.mainWebService.service;

import com.indieplay.mainWebService.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    boolean existsByUsername(String username);

    void save(User user);

    User get(String username);

    User get(Long id);
}
