package com.ing.hubs.controllers;

import com.ing.hubs.exceptions.AccountNotFoundException;
import com.ing.hubs.exceptions.ConstraintException;
import com.ing.hubs.exceptions.UserNotFoundException;
import com.ing.hubs.models.AuthRequest;
import com.ing.hubs.models.RegisterRequest;
import com.ing.hubs.models.Request;
import com.ing.hubs.models.User;
import com.ing.hubs.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws ConstraintException {
        userService.register(request);
        return ResponseEntity.ok("Successfully registered " + request.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(userService.authenticate(authRequest));

    }

    @GetMapping("/all")
    public ResponseEntity<String> showAllUsers(HttpServletRequest request) throws UserNotFoundException, AccountNotFoundException {
        List<User> userList;
        userList = userService.getAllUsers(request);
        String response = "Here are all Users in DB:\n--------------------------------------------------------------\n"
                + "id  || first_name || last_name || username\n";
        for (User user : userList) {
            response = response + ("\n" + user.getId() + "   ||    " + user.getFirstName() + "   ||   " + user.getLastName() + "   ||      " + user.getUsername());

        }
        System.out.println(response);
        return ResponseEntity.ok(response);

    }
}
