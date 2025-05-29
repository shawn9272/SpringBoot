package mvc.example.demo.service;


import lombok.RequiredArgsConstructor;
import mvc.example.demo.entity.Post;
import mvc.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional // 트랜젝션 어노테이션 : 모든 과정이 성공하거나 모두 실패해서 원래대로 돌아가야 한다는 원자성 보장
    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
        return post;
    }
}
