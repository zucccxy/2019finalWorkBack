package org.hzqisheng.controller;

import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.UserService;
import org.lis_entity.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.form.RadioButtonsTag;
import org.util.EnumState;
import org.util.MD5;
import org.util.StringUtil;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
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
     *
     * @param userAccount
     * @param userPwd
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userLogIn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logIn(String userAccount, String userPwd, HttpSession session) throws Exception {
        if (StringUtil.isBlank(userAccount) || StringUtil.isBlank(userPwd)) {
            return ResponseDataUtil.fail("账号密码不能为空！").build();
        }
        User user = userService.findUserByAccount(userAccount);
        if (null == user) {
            return ResponseDataUtil.fail("账号不存在！").build();
        }
        log.info("用户登录------------------------------------");
        if (userPwd.equals(user.getPassword())) {
            session.setAttribute("currUser", user);
            return ResponseDataUtil.
                    ok().
                    putData("data", session.getId()).
                    putData("user", session.getAttribute("currUser")).
                    build();
        } else {
            return ResponseDataUtil.fail("密码错误！").build();
        }
    }

    /**
     * 用户退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logOut", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logOut(HttpSession session) {
        log.info("用户退出登录------------------------------------");
        session.setAttribute("currUser", null);
        return ResponseDataUtil.ok().build();
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "userRegister", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(User user) {
        userService.addUser(user);
        log.info("用户注册------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("data", user).
                build();
    }

    /**
     * 提交用户反馈
     *
     * @param feedback
     * @return
     */
    @RequestMapping(value = "submitFeedback", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> submitFeedback(Feedback feedback) {
        feedback.setCreatTime(new Date());
        userService.addFeedback(feedback);
        log.info("提交用户反馈------------------------------------");
        return ResponseDataUtil.
                ok().
                build();

    }

    /**
     * 获取用户收藏列表
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "collectionList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> collectionList(@RequestParam Long userId) {
        List<CollectionResult> collectionResultList = userService.getCollectionResultListByUserId(userId);
        log.info("获取用户收藏列表------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", collectionResultList).
                build();
    }

    /**
     * 用户签到
     *
     * @param sign
     * @return
     */
    @RequestMapping(value = "addSign", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSign(Sign sign) {
        userService.addSign(sign);
        log.info("用户签到------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }


    /**
     * 统计用户签到次数
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "countSign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> countSign(@RequestParam Long userId) {
        Long count = userService.countSign(userId);
        log.info("统计用户签到次数------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataCount", count).
                build();
    }

    /**
     * 判断用户是否能签到(一天只能签到一次)
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "getIsSign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getIsSign(@RequestParam Long userId) {
        Map<String, Object> result = userService.judgeIsSign(userId);
        log.info("判断用户是否能签到(一天只能签到一次)-----------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataResult", result.get("result")).
                putData("dataList", result.get("resultData")).
                build();
    }

    /**
     * 获取消息列表
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "getNewsList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNewsList(@RequestParam Long userId) {
        List<News> newsList = userService.findNewsList(userId);
        log.info("获取消息列表------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", newsList).
                build();
    }

    /**
     * 统计用户未读消息数
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "getUnReadNew", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUnReadNew(@RequestParam Long userId) {
        Long resultCount = userService.countUnReadNew(userId);
        log.info("统计用户未读消息数------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("resultCount", resultCount).
                build();
    }

    /**
     * 更新消息状态
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "updateNewsStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateNewsStatus(@RequestParam Long userId) {
        userService.updateNewStatus(userId);
        log.info("更新消息状态------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 用户修改账号
     *
     * @return
     */
    @RequestMapping(value = "updateUserAccount", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserAccount(User user) {
        List<User> userList = userService.findUserByUserAccount(user.getAccount());
        if (userList.size() != 0) {
            return ResponseDataUtil.
                    fail("账号已存在！").
                    build();
        } else {
            userService.updateUser(user);
            log.info("用户修改账号------------------------------------");
            return ResponseDataUtil.
                    ok().
                    build();
        }
    }

    /**
     * 用户修改用户名
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUsername", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUsername(User user) {
        List<User> userList = userService.findUserByUsername(user.getUsername());
        if (userList.size() != 0) {
            return ResponseDataUtil.
                    fail("用户名已存在！").
                    build();
        } else {
            userService.updateUser(user);
            log.info("用户修改用户名------------------------------------");
            return ResponseDataUtil.
                    ok().
                    build();
        }
    }

    /**
     * 用户修改密码
     *
     * @return
     */
    @RequestMapping(value = "updateUserPassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserPassword(User user) {
        userService.updateUser(user);
        log.info("用户修改密码------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 用户删除消息
     *
     * @param newsId
     * @return
     */
    @RequestMapping(value = "deleteNew", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteNew(@RequestParam Long newsId) {
        userService.deleteNews(newsId);
        log.info("用户删除消息------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 通过用户ID查找用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUser(@RequestParam Long userId) {
         User user=userService.findUserByUserId(userId);
        log.info("通过用户ID查找用户------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataResult", user).
                build();
    }
}
