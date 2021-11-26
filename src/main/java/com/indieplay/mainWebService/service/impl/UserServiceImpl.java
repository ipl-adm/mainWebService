package com.indieplay.mainWebService.service.impl;

import com.indieplay.mainWebService.domain.entity.User;
import com.indieplay.mainWebService.domain.repository.UserRepository;
import com.indieplay.mainWebService.exception.NotFoundException;
import com.indieplay.mainWebService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(User.class));
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Not found: " + username);
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(User.class));
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(User.class));
    }
}
