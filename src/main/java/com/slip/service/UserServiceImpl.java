package com.slip.service;

import com.slip.user.User;
import com.slip.user.UserRepository;
import com.slip.vo.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String register(UserRequest request) throws AlreadyExistException {
        try{
            userRepository.save(
                    User.builder()
                            .userId(request.getUserId())
                            .password(request.getPassword())
                            .build()
            );
            return "Success";
        }catch(Exception e){
            throw new AlreadyExistException();
        }
    }
}