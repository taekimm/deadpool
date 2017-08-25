package com.tae.deadpool.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Deadpool;
import com.tae.deadpool.models.Pick;
import com.tae.deadpool.models.User;
import com.tae.deadpool.repositories.DeadpoolRepository;
import com.tae.deadpool.repositories.RoleRepository;
import com.tae.deadpool.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private DeadpoolRepository deadpoolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, DeadpoolRepository deadpoolRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.deadpoolRepository = deadpoolRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User findById(Long userId) {
    		return userRepository.findOne(userId);
    }
    public List<User> findAll(){
    		return (List<User>) userRepository.findAll();
    }
    
    public void deleteUser(Long userId) {
    		User user = userRepository.findOne(userId);
    		userRepository.delete(user);
    }
    
    public void makeAdmin(Long userId) {
    		User u = userRepository.findOne(userId);
    		u.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    		userRepository.save(u);
    }
    
}