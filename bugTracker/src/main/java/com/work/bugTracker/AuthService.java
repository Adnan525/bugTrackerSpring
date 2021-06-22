package com.work.bugTracker;

import com.work.bugTracker.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    RepositoryUser opUser;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        UserDetails temp = opUser.findByUserName(userName);
//        System.out.println("user found:"+temp.getUsername()+" password:"+temp.getPassword()+" with type:"+temp.getAuthorities().toString());
//        return temp;
        return opUser.findByUserName(userName);
    }
}
