package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.morcherlf.pharmacy.entity.User;
import ru.morcherlf.pharmacy.entity.param.LoginParam;
import ru.morcherlf.pharmacy.entity.param.RegisterParam;
import ru.morcherlf.pharmacy.repository.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    final UserRepository userRepository;

//  Register
    @PostMapping("/register")
    User register(@RequestBody RegisterParam registerParam) {
        String username = registerParam.getUsername();
//      String usernamePattern = "/^[A-Za-z0-9-]+$/";
        if (userRepository.existsByUsername(username)){
            return null;
        }else {
            User user = new User();
            user.setUsername(registerParam.getUsername());
            user.setPassword(registerParam.getPassword());
            user.setEmail(registerParam.getEmail());
            return userRepository.save(user);
        }
    }

//  Login
    @PostMapping("/login")
    User login(@RequestBody LoginParam loginParam){
        String username = loginParam.getUsername();
        if (userRepository.existsByUsername(username)){
            User user = userRepository.findByUsername(username);
            String password = user.getPassword();
            if (password.equals(loginParam.getPassword())){
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @GetMapping("/userlist")
    List<User> getUserList() {
        return userRepository.findAll();
    }


//
}
