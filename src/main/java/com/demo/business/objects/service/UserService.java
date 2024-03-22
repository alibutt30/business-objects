package com.demo.business.objects.service;

import com.demo.business.objects.in.rest.bo.User;
import com.demo.business.objects.in.rest.dto.UserRequestDto;
import com.demo.business.objects.out.db.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequestDto userRequestDto) {
        return userRepository.createUser(userRequestDto);
    }

    public User getUser(Long userId) {
        // logic goes here
        return userRepository.getUserById(userId);
    }

}
