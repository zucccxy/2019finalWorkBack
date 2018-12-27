package org.hzqisheng.controller;

import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.UserService;
import org.lis_entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.EnumState;
import org.util.MD5;
import org.util.StringUtil;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author thlnkpad
 * @Date 2018/12/26 17:21
 **/
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("api/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 用户登录
     * @param userAccount
     * @param userPwd
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "logIn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logIn(String userAccount, String userPwd, HttpSession session) throws Exception {
        if (StringUtil.isBlank(userAccount) || StringUtil.isBlank(userPwd)) {
            return ResponseDataUtil.fail("账号密码不能为空！").build();
        }
        User user = userService.findUserByAccount(userAccount);
        if (null == user) {
            return ResponseDataUtil.fail("账号不存在！").build();
        }
        log.info("管理员登录....................");
        if (userPwd.equals(user.getPassword())) {
            session.setAttribute("currUser", user);
            return ResponseDataUtil.ok().putData("data", user).build();
        } else {
            return ResponseDataUtil.fail("密码错误！").build();
        }
    }
}
