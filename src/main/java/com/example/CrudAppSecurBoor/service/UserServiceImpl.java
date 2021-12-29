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



import com.example.CrudAppSecurBoor.models.User;
import com.example.CrudAppSecurBoor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void edit(User editUser) {
        userRepository.save(editUser);
    }

    public User printUserById(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> printUsers(){
        return userRepository.findAll();
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }

}