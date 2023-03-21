package com.example.shop.controllers;

import com.example.shop.entities.UserEntity;
import com.example.shop.exceptions.UserAlreadyExistsException;
import com.example.shop.exceptions.UserNotFoundException;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.shop.responsecontent.ErrorResponse.badRequestApiResponse;
import static com.example.shop.responsecontent.ErrorResponse.notFoundApiResponse;
import static com.example.shop.responsecontent.UserResponse.UNKNOWN_EXCEPTION;
import static com.example.shop.responsecontent.UserResponse.USER_SUCCESSFULLY_REMOVED;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.create(user));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(badRequestApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }

    @GetMapping("/list")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserInfo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(notFoundApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity removeUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(String.format(USER_SUCCESSFULLY_REMOVED, userService.delete(id)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(notFoundApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }

//some new test feature
    @DeleteMapping("/user/{id}")
    public ResponseEntity removeUser2(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(String.format(USER_SUCCESSFULLY_REMOVED, userService.delete(id)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(notFoundApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }

    //some new test feature
    @DeleteMapping("/user/{id}")
    public ResponseEntity removeUser3(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(String.format(USER_SUCCESSFULLY_REMOVED, userService.delete(id)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(notFoundApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UNKNOWN_EXCEPTION);
        }
    }
}
