package com.vega.springit.service;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    //private final RoleService roleService;
    private final UserRepository userRepository;

    public UserService(/*RoleService roleService,*/ UserRepository userRepository) {
        //this.roleService = roleService;
        this.userRepository = userRepository;
    }

    public User register(User user) {
    	return user;
    }
    
    public User save(User user){
    	return userRepository.save(user);
    }
    
    @Transactional
    public void saveUsers(User... users) {
        // begin transaction
        for(User user : users) {
            logger.info("Saving User: " + user.getEmail());
                userRepository.save(user);
            
        }
        // commit transaction
    }
    
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id){
    	return userRepository.findById(id);
    }
    	
    

}
