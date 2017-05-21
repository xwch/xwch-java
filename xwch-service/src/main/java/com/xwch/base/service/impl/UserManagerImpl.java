package com.xwch.base.service.impl;

import com.xwch.base.bean.UserDAO;
import com.xwch.base.bean.UserDAOExample;
import com.xwch.base.dao.UserDAOMapper;
import com.xwch.base.service.UserManager;
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

    public List<UserDAO> queryUserByUserName(UserDAO userDAO) {
        UserDAOExample po = new UserDAOExample();
        UserDAOExample.Criteria criteria = po.createCriteria();
        criteria.andUserNameLike(userDAO.getUserName());
        criteria.andStatEqualTo(userDAO.getStat());
        return userDAOMapper.selectByExample(po);
    }
}
