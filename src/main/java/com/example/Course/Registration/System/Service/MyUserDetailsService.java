package com.example.Course.Registration.System.Service;

import com.example.Course.Registration.System.Model.UserPrincipal;
import com.example.Course.Registration.System.Model.Users;
import com.example.Course.Registration.System.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= repo.getByUsername(username);

       if(user == null){
           throw new UsernameNotFoundException("User not found");
       }
       return new UserPrincipal(user);
    }
}
