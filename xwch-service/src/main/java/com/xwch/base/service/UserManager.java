package com.xwch.base.service;

import com.xwch.base.bean.UserDAO;

import java.util.List;

/**
 * Created by xwch on 2017/5/15.
 */
public interface UserManager {

    UserDAO queryUserByUserId(String userID);

    List<UserDAO> queryUserByUserName(String userName);
}
