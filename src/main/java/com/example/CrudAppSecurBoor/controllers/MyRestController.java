package com.example.CrudAppSecurBoor.controllers;

import com.example.CrudAppSecurBoor.models.User;
import com.example.CrudAppSecurBoor.service.RoleService;
import com.example.CrudAppSecurBoor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/")
public class MyRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @GetMapping("/allusers")
    public List<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return userService.show(id);
    }
//
    @PostMapping("/newUser")
    public User addUserBd(@RequestBody User user) {
        User user1 = user;
        return userService.save(user1);
    }
//
//
    @PutMapping("/edit")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
//
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
