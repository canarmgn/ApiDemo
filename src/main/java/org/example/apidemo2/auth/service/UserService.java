package org.example.apidemo2.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.apidemo2.auth.repository.UserRepository;
import org.example.apidemo2.auth.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }
}
