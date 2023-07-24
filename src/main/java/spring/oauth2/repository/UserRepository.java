package spring.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.oauth2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    //findBy 규칙 -> Username 문법
    //select * from user where username = 1?
    public User findByUsername(String username);


}
