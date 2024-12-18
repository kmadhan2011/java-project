package com.example.FamilyMember;


import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @GetMapping("/signup")
    public String signup(@RequestBody User user) {
        return "User registered successfully";
    }


}

