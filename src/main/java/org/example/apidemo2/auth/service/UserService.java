package org.example.apidemo2.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.apidemo2.apiRespository.ArticleRepository;
import org.example.apidemo2.auth.model.User;
import org.example.apidemo2.auth.repository.UserRepository;
import org.example.apidemo2.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    public List<Article> dailyHeadlines() {
        return articleRepository.findAll();
    }
}
