package com.example.parth.Authentication;


import com.example.parth.entity.User;
import com.example.parth.exception.NotFoundException;
import com.example.parth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            /*throw new UsernameNotFoundException("Could not find user");*/
            throw new NotFoundException("Could not find user");
        }
        return new ApplicationUser(user);
    }

}