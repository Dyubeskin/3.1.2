package com.example.CrudAppSecurBoor.service;

import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.models.User;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void add(Role role);

    void edit(Role role);

    Role getById(Long id);

    Role getByRole(String name);
}