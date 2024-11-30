package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.Errors;

@RestController
@CrossOrigin(origins = "http://43.203.123.198:3000")
@RequestMapping("/api/users")
@Validated  // Spring Validation을 사용하도록 설정
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public User signup(@RequestBody @Validated User user, Errors errors) {
        if (errors.hasErrors()) {
            // 검증 오류가 있을 경우 처리
            return null; // 검증 실패시 null 반환 혹은 오류 처리
        }
        return userService.createUser(user);
    }

    // 프로필 조회
    @GetMapping("/profile")
    public User getProfile(@RequestParam String email) {
        return userService.getUserProfile(email);
    }
}
