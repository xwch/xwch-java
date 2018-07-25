package com.xwch.base.comtroller;

import com.xwch.base.bean.UserDAO;
import com.xwch.base.service.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xwch on 2017/6/15.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserManager userManager;

    @RequestMapping("/{userId}")
    @ResponseBody
    public UserDAO getUserInfoByName(@PathVariable("userId") String userId){
        UserDAO userDAO;
        try {
            userDAO = userManager.queryUserByUserId(userId);
            return userDAO;
        } catch (Exception e){
            log.error("查询系统异常",e);
            return null;
        }
    }
}
