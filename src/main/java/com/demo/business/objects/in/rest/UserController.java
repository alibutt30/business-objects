package com.demo.business.objects.in.rest;

import com.demo.business.objects.in.rest.bo.User;
import com.demo.business.objects.in.rest.dto.UserRequestDto;
import com.demo.business.objects.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

}
