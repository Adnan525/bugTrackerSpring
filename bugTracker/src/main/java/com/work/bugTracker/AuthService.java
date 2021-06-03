package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
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
        return opUser.findByUserName("userName");
    }
}
