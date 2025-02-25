package com.revisionplanner.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import java.security.Principal;

@RestController
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<?> getUser(Principal principal) {
        return ResponseEntity.ok().build();
    }
} 