package com.fovoy.daemon.model;

import com.fovoy.daemon.model.Type.UserType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zxz.zhang on 16/9/10.
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 3977088664942395573L;
    private int userId;
    private String userName;
    private int parentUserId;
    private String parentUserName;
    private UserType userType;
    private String userIp;
    private List<String> roleList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(int parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getParentUserName() {
        return parentUserName;
    }

    public void setParentUserName(String parentUserName) {
        this.parentUserName = parentUserName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
