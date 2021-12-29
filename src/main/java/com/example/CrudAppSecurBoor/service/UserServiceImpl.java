package com.example.CrudAppSecurBoor.service;
//
//import org.example.crud.dao.UserDAO;
//import org.example.crud.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    private final UserDAO userDAO;
//
//    public UserServiceImpl(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @Override
//    public List<User> index() {
//        return userDAO.index();
//    }
//
//    @Override
//    public User show(int id) {
//        return userDAO.show(id);
//    }
//
//    @Override
//    public void save(User user) {
//        userDAO.save(user);
//    }
//
//    @Override
//    public void update(int id, User updatedUser) {
//        userDAO.update(id, updatedUser);
//    }
//
//    @Override
//    public void delete(int id) {
//        userDAO.delete(id);
//    }
//}



import com.example.CrudAppSecurBoor.models.Role;
import com.example.CrudAppSecurBoor.models.User;
import com.example.CrudAppSecurBoor.repository.RoleRepo;
import com.example.CrudAppSecurBoor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepo roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User show(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public Role showRole(Long id) {
        Optional<Role> optionalUser = roleRepository.findById(Math.toIntExact(id));

        return optionalUser.get();
    }

    @Override
    public User update(User user) {

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByEmail(userName);
    }
}
