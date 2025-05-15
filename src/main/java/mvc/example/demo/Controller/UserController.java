package mvc.example.demo.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mvc.example.demo.entity.User;
import mvc.example.demo.repository.UserRepository;
import mvc.example.demo.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // /user/signup URL이 GET으로 요청되면 회원 가입을 위한 템플릿을 렌더링
    @GetMapping("/signup")
    public String signup(User user) {
        return "signup_form";
    }

    // /user/signup URL이 POST으로 요청되면 회원 가입을 진행
    @PostMapping("/signup")
    public String signup(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        userService.create(user.getUsername(), user.getEmail(), user.getPassword());

        return "redirect:/";
    }


}
