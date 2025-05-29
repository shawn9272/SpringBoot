package mvc.example.demo.Controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mvc.example.demo.entity.Post;
import mvc.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController // JSON 반환용 (템플릿X)
@RequiredArgsConstructor
@RequestMapping("/posts") // 엔드포인트 경로
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest request) {
        return postService.createPost(request.getTitle(), request.getContent());
    }

    // 요청값 받기용 내부 DTO
    @Setter
    @Getter
    public static class PostCreateRequest {
        // Getter/Setter 필수 (JSON 바인딩 위해)
        private String title;
        private String content;

    }
}
