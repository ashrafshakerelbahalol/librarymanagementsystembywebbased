package com.global.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.librarymanagementsystem.entity.User;
import com.global.librarymanagementsystem.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
       return (List<User>)userRepository.findAll();
    }

    public User addUser(User user) {
        User currentUser =new User();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setUserId(user.getUserId());
        currentUser.setUserType(user.getUserType());
        currentUser.setAddress(user.getAddress());
        return userRepository.save(currentUser);
    }

    public User updateUser(User user) {
        User currentUser = userRepository.findById(user.getUserId()).get();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setUserId(user.getUserId());
        currentUser.setUserType(user.getUserType());
        currentUser.setAddress(user.getAddress());
        return userRepository.save(currentUser);
    }

    public User findUser(int id) {
       return userRepository.findById(id).get();
    }
    public void deleteUser(int id) {
       User userToDelete= userRepository.findById(id).get();
       userRepository.delete(userToDelete);
     }

}
