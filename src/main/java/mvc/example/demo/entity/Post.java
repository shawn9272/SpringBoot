package mvc.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Size(min = 1, max = 20)
    @NotBlank(message = "제목 입력은 필수입니다.")
    private String title;

    @Setter
    @Size(min = 1, max = 1000)
    @NotBlank(message = "본문 입력은 필수입니다.")
    private String content;

    @CreationTimestamp // Entity가 처음 저장될 때 현재 시간을 자동으로 넣어줌
    private LocalDateTime createdAt;

    @UpdateTimestamp // Entity가 수정될 때마다 현재 시간을 자동으로 넣어줌
    private LocalDateTime updatedAt;
}
