package com.example.CrudAppSecurBoor.service;


import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    User show(Long id);

    User update(User user);

    Role showRole(Long id);

    void delete(Long id);

    User findByUserName(String userName);

}