package com.work.bugTracker.dataModel;

import javax.persistence.*;

@Table(
        name = "trackerUsers"
)
@Entity
public class UserModel {

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
    private int userType; // 0 for developer, any for tester

    public UserModel(String userName, String userPassword, int userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
