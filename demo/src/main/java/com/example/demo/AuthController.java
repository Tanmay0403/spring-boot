package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private static final String username = "admin";
    private static final String password = "admin";

    @PostMapping("/login")
    public AuthenticateDTO login(@RequestBody AuthenticateDTO request) {
        if (username.equals(request.getUsername()) &&
            password.equals(request.getPassword())) {
            request.setStatus("success");
            request.setMessage("Login successful!");
        } else {
            request.setStatus("failed");
            request.setMessage("Invalid username or password!");
        }
        // Returning same object back with result info
        return request;
    }
}
