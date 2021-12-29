package com.example.CrudAppSecurBoor.service;

import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.repository.RoleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepository;

    public RoleServiceImpl(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void add(Role role) {
        roleRepository.save(role);
    }

    public void edit(Role role) {
        roleRepository.save(role);
    }

    public Role getById(Long id) {
        Role role = null;
        Optional<Role> opt = roleRepository.findById(Math.toIntExact(id));
        if (opt.isPresent()) {
            role = opt.get();
        }
        return role;
    }

    public Role getByRole(String name) {
        return roleRepository.findByRole(name);
    }
}