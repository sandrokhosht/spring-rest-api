package com.sandrokhosht.rest.api.controller;

import com.sandrokhosht.rest.api.dao.UserRepository;
import com.sandrokhosht.rest.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existingUser = repository.findUserByEmail(user.getEmail());
        if(existingUser==null){
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
        }
        else return "User with email " + user.getEmail() + " already exists";
    }
    
    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public User findUser(@PathVariable String email) {
        return repository.findUserByEmail(email);
    }

    @DeleteMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email) {
        User existingUser = repository.findUserByEmail(email);
        if(existingUser!=null){
            repository.deleteUserByEmail(email);
            return "User with email: " + email + " deleted successfully";
        }
        else return "No users with email: " + email + " found"; //
    }
}


