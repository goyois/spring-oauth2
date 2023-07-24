package spring.oauth2.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.oauth2.entity.User;
import spring.oauth2.repository.UserRepository;


@Service  //PrincipalDetalis 는 추후 강제로 띄움
//login 요청이 오면 자동으로 UserDatailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행
// view 단에서 보여주는 input 네임과 loadUserByUsername 파라미터명이 같아야함
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    //UserDetails 타입의 리턴 값이 Authentication 으로 들어가서 Authentication 이 Security ContextHolder 에 속하게 됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
