package cn.com.homesangsang.testsecurity.conftoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @RequestMapping("/api/currentuser")
    public Principal user(Principal user) {
        return user;
    }

}
