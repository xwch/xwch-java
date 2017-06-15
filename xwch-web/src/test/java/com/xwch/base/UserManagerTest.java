package com.xwch.base;

import com.xwch.base.bean.UserDAO;
import com.xwch.base.service.UserManager;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xwch on 2017/5/15.
 */

public class UserManagerTest extends BaseTest {

    @Resource
    UserManager userManager;


    @Test
    public void queryTest(){
    }
}
