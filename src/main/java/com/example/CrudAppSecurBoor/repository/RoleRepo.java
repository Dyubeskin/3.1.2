package com.example.CrudAppSecurBoor.repository;

import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
   Role findByRole(String role);
}
