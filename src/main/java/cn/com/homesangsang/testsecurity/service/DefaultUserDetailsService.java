package cn.com.homesangsang.testsecurity.service;

import cn.com.homesangsang.testsecurity.UserRepository;
import cn.com.homesangsang.testsecurity.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity.isPresent()) {
            final UserEntity ua = userEntity.get();
            return new User(ua.getUsername(), ua.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(ua.getRoles())));
        }
        return null;
    }
}
