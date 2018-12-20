package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.lis_entity.FeedbackResult;
import org.lis_entity.Sign;
import org.lis_entity.SignResult;
import org.lis_entity.User;
import lombok.extern.slf4j.Slf4j;
import org.enums.ResponseCodeEnum;
import org.hzqisheng.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.MD5;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author thlnkpad
 * @Date 2018/12/17 10:07
 **/
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("back/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 用户列表
     * @param pageIndex
     * @param pageSize
     * @param userAccount
     * @param userName
     * @param userLevel
     * @return
     */
    @RequestMapping(value="userList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findUserList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                             String userAccount, String userName, Integer userLevel) {
            PageHelper.startPage(pageIndex, pageSize);
            List<User> userList = userService.findUserList(userAccount, userName, userLevel);
            Page<User> page = (Page<User>) userList;
            log.info("用户列表查询------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("dataList", userList).
                    putData("pageIndex", pageIndex).
                    putData("pageSize", pageSize).
                    putData("totalCount", page.getTotal()).
                    build();
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping(value="delUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delUser(User user){
        userService.delUser(user.getUserId());
        log.info("删除用户------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(User  user) {
        userService.addUser(user);
        log.info("新增用户------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("data", user).
                build();
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateAdmin(User user) {
        if (userService.updateUser(user)) {
            return ResponseDataUtil.
                    ok().
                    putData("data", user).
                    build();
        } else
            return ResponseDataUtil.
                    fail().
                    build();
    }

    /**
     * 用户签到列表
     * @param pageIndex
     * @param pageSize
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="signList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findSignList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                            String username, Date startTime,Date endTime) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SignResult> signList = userService.findSignList(username, startTime, endTime);
        Page<SignResult> page = (Page<SignResult>) signList;
        log.info("用户签到列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", signList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 删除签到记录
     * @param signId
     * @return
     */
    @RequestMapping(value="delSign",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delSign(Long signId){
        userService.delSign(signId);
        log.info("删除标签------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 获取反馈列表
     * @param pageIndex
     * @param pageSize
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="feedbackList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findFeedbackList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                            String username, Date startTime,Date endTime) {
        PageHelper.startPage(pageIndex, pageSize);
        List<FeedbackResult> feedbackList = userService.findFeedbackList(username, startTime, endTime);
        Page<FeedbackResult> page = (Page<FeedbackResult>) feedbackList;
        log.info("用户签到列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", feedbackList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 删除反馈
     * @param feedbackId
     * @return
     */
    @RequestMapping(value="delFeedback",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delFeedback(Long feedbackId){
        userService.delFeedback(feedbackId);
        log.info("删除反馈------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }
}
