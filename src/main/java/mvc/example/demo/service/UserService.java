package mvc.example.demo.service;

import lombok.RequiredArgsConstructor;
import mvc.example.demo.entity.User;
import mvc.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        this.userRepository.save(user);
        return user;
    }
}
