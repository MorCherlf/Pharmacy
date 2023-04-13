package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.morcherlf.pharmacy.entity.User;
import ru.morcherlf.pharmacy.entity.param.RegisterParam;
import ru.morcherlf.pharmacy.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {
    final UserRepository userRepository;

//  Register
    @PostMapping("/register")
    User register(@RequestBody RegisterParam registerParam) {
        String username = registerParam.getUsername();
//        String usernamePattern = "/^[A-Za-z0-9-]+$/";

        if (userRepository.existsByUsername(username)){
            return null;
        }else {
            User user = new User();
//            if ()
            user.setUsername(registerParam.getUsername());
            user.setPassword(registerParam.getPassword());
            user.setEmail(registerParam.getEmail());
            return userRepository.save(user);
        }
    }

//  Login
//    @PostMapping("/login")
//    String Login()


//
}
