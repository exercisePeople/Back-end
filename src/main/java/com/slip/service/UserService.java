package com.slip.service;

import com.slip.vo.UserRequest;

public interface UserService {
    String register(UserRequest request) throws AlreadyExistException;
}