package Controller;

import Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    // 회원 등록
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(idCounter.incrementAndGet());
        users.add(user);
        return user;
    }

    // 회원 목록 조회
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
