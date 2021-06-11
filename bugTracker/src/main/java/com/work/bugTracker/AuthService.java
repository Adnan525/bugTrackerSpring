package com.work.bugTracker;

import com.work.bugTracker.dataModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthEditorPaneUI;

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
