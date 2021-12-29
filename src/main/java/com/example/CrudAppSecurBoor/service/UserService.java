package com.example.CrudAppSecurBoor.service;


import com.example.CrudAppSecurBoor.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(Long id);

    void edit(User user);

    User printUserById(Long id);

    List<User> printUsers();

}