package com.example.CrudAppSecurBoor.controllers;


import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.models.User;
import com.example.CrudAppSecurBoor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}