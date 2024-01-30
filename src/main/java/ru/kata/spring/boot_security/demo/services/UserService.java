package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User createUser(User user) {
        // TODO: add patterns
        if ((user.getEmail() == null)
                || user.getEmail().isEmpty()
                || (userRepository.findUserByEmail(user.getEmail()) != null)) {
            return null;
        }

        if ((user.getPassword() == null) || user.getPassword().isEmpty()) {
            return null;
        }

        if ((user.getName() == null) || user.getName().isEmpty()) {
            return null;
        }

        if (user.getGender() == null) {
            return null;
        }

        if ((user.getRole() == null) || user.getRole().isEmpty()) {
            return null;
        }

        User newUser = userRepository.save(user);
        userRepository.flush();
        return newUser;
    }
}
