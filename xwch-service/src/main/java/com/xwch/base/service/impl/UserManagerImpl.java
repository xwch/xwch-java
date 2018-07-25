package com.xwch.base.service.impl;

import com.xwch.base.bean.UserDAO;
import com.xwch.base.bean.UserDAOExample;
import com.xwch.base.dao.UserDAOMapper;
import com.xwch.base.service.UserManager;
import com.xwch.constant.Constant;
import com.xwch.enums.UsableFlagEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwch on 2017/5/15.
 */
@Service("userManagerImpl")
public class UserManagerImpl implements UserManager {
    @Autowired
    UserDAOMapper userDAOMapper;

    public UserDAO queryUserByUserId(String userID) {
        UserDAOExample po = new UserDAOExample();
        UserDAOExample.Criteria criteria = po.createCriteria();

        criteria.andUserIdEqualTo(userID);
        criteria.andStatEqualTo(UsableFlagEnums.USABLE.getUsableFlag());

        List<UserDAO> list = userDAOMapper.selectByExample(po);
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public List<UserDAO> queryUserByUserName(String userName) {
        UserDAOExample po = new UserDAOExample();
        UserDAOExample.Criteria criteria = po.createCriteria();
        if (!userName.isEmpty()){
            userName = Constant.SQLLIKE+userName+Constant.SQLLIKE;
        }
        System.out.println("userName--->"+userName);

        criteria.andUserNameLike(userName);
        criteria.andStatEqualTo(UsableFlagEnums.USABLE.getUsableFlag());

        return userDAOMapper.selectByExample(po);
    }
}
