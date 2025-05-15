package mvc.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // id, name, email 에 대한 getter, setter 사용? -> 데이터 무결성에 관한 문제로 setter는 사용하지 않는게 좋다.
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    // Getter/Setter
    @Id // DB의 기본 키(PK) 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 자동으로 생성하도록 지정.
    // strategy는 생성 전략을 의미. GenerationType.IDENTITY 특징은 DB에서 기본 키를 자동으로 증가시키는 전략.
    // 엔티티를 persist() 할 때 DB가 자동으로 ID를 생성. JPA가 그 값을 가져온다.
    private Long id;

    @Size(min = 3, max = 50) // 해당 사용자의 이름의 길이를 3~50으로 제한
    @Column(unique = true)// 해당 필드를 데이터베이스 열에 매핑. 추가 설정 지정 가능
    // unique = true 는 해당 열에 유일성 제약 조건을 설정. 해당 값은 중복될 수 없고, DB 차원에서 고유한 값만 허용
    @NotBlank(message = "사용자 이름은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;

    @Column(unique = true)
    @NotBlank(message = "이메일 입력은 필수입니다.")
    private String email;

    // @NotBlank 와 @NotEmpty 차이
    // 둘 다 문자열이 비어있지 않은지 확인하는 어노테이션으로 @NotBlank는 null, ""(빈 문자열), " "(공백문자열) 모두 허용하지 않는다.
    // 하지만 @NotEmpty는 " "(공백 문자열)은 허용한다.
}
