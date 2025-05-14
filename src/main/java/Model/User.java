package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter // id, name, email 에 대한 getter, setter 사용?
@Getter
@Entity
public class User {
    // Getter/Setter
    @Id // DB의 기본 키(PK) 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 자동으로 생성하도록 지정.
    // strategy는 생성 전략을 의미. GenerationType.IDENTITY 특징은 DB에서 기본 키를 자동으로 증가시키는 전략.
    // 엔티티를 persist() 할 때 DB가 자동으로 ID를 생성. JPA가 그 값을 가져온다.
    private Long id;

    @Column(unique = true) // 해당 필드를 데이터베이스 열에 매핑. 추가 설정 지정 가능
    // unique = true 는 해당 열에 유일성 제약 조건을 설정. 해당 값은 중복될 수 없고, DB 차원에서 고유한 값만 허용
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    // 생성자
    public User() {}

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

}
