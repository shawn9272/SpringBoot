package mvc.example.demo.repository;
import mvc.example.demo.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;

// <User, Long> 엔티티 클래스와 그 클래스의 기본키 타입을 넣어준다.
public interface UserRepository extends JpaRepository<User, Long> {
}