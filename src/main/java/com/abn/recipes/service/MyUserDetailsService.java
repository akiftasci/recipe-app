package com.abn.recipes.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        //Credentials are stored in the memory which is definetly not a safe thing to do. But for
        //now just for testing I kept them in the memory I have time left I will encrypt and store
        //in the database.
        //TODO: Encrypt credentials and store in database.
        return new User("akiftasci","abnamro", new ArrayList<>());
    }
}
