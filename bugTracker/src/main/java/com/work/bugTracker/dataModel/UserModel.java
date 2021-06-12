package com.work.bugTracker.dataModel;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Table(
        name = "trackerUsers"
)
@Entity
public class UserModel implements UserDetails {
    public UserModel() {
        super();
    }
    @Id
    @SequenceGenerator(
            name = "uid_sequence",
            sequenceName = "uid_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "uid_sequence"
    )
    private Long UID; //pk
    private String userName;
    private String userPassword; //will be converted to sha256 later
    private String userType; // 0 for developer, any for tester
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;

    public UserModel(String userName, String userPassword, String userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.isEnabled = true;
        this.isCredentialsNonExpired = true;
        this.isAccountNonLocked = true;
        this.isAccountNonExpired = true;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }
//    public void setUserType(int userType) {
//        this.userType = userType;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.userType));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
