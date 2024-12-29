package com.global.librarymanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.global.librarymanagementsystem.entity.User;
import com.global.librarymanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getalluser")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }
    @GetMapping("/getuser/{id}")
    public User  getUser(@PathVariable int id) {
        return userService.findUser(id);
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    

}
