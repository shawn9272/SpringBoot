package mvc.example.demo.Controller;
import mvc.example.demo.entity.User;

public class test {
    public static void main(String[] args) {
        User u = new User(234L, "강인성", "shawn9272@naver.com");
        long id = u.getId();
        String name = u.getName();
        String email = u.getEmail();




    }
}
