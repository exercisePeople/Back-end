package com.slip.controller;

import com.slip.service.AlreadyExistException;
import com.slip.service.UserService;
import com.slip.user.User;
import com.slip.user.UserRepository;
import com.slip.vo.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class WebController {

    private final UserRepository userRepository;

    private final UserService userService;

    @GetMapping("/member")
    public List<User> findAllMember(){
        return userRepository.findAll();
    }

    @PostMapping("/member")
    public String login(@RequestBody UserRequest user) throws AlreadyExistException {
        return userService.register(user);
    }


}
