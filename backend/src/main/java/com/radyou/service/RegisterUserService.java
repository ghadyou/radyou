package com.radyou.service;

import com.radyou.domain.User;
import com.radyou.repo.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class RegisterUserService {

    private static final Logger log = Logger.getLogger(RegisterUserService.class);
    @Autowired
    private UserRepository userRepository;


    public String generateConfirmationKey() {
    	return UUID.randomUUID().toString();
    }
    
    public void register(String username, String password, String email, String confirmationKey) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("user exists!");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("email is occupied!");
        }

        User user = new User(username, password, email, confirmationKey);

        //TODO: send email

        userRepository.save(user);
    }

    public void register(String name, String email, String providerId) {
        if (!userRepository.findByAuthProviderId(providerId).isPresent()) {
            userRepository.save(new User(name, email, providerId));
        }
    }
}
