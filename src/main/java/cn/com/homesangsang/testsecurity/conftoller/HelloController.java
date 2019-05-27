package cn.com.homesangsang.testsecurity.conftoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/currentuser")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return "from server: " + name;
    }
}
