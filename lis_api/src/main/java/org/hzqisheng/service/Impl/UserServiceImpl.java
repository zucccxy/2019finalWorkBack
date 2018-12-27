package org.hzqisheng.service.Impl;

import org.hzqisheng.service.UserService;
import org.lis_dao.FeedbackDao;
import org.lis_dao.UserDao;
import org.lis_entity.Feedback;
import org.lis_entity.User;
import org.lis_entity.UserExample;
import org.springframework.stereotype.Service;
import org.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/26 17:16
 **/
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;
    @Resource
    FeedbackDao feedbackDao;
    @Override
    public User findUserByAccount(String account) {
        UserExample userExample=new UserExample();
        if (StringUtil.isBlank(account))
            return null;
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        List<User> userList=userDao.selectByExample(userExample);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.insertSelective(user) > 0;
    }

    @Override
    public boolean addFeedback(Feedback feedback) {
        return feedbackDao.insertSelective(feedback) > 0;
    }
}
