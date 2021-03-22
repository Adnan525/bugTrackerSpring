package com.work.bugTracker.dataModel;

public class UserModel {
    private long UID;
    private String userName;
    private String userPassword; //will be converted to sha256 later
    private int userType; // 0 for developer, 1 for tester

    public UserModel(long UID, String userName, String userPassword, int userType) {
        this.UID = UID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
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
