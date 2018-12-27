package org.hzqisheng.service;

import org.lis_entity.Feedback;
import org.lis_entity.User;

/**
 * @Author thlnkpad
 * @Date 2018/12/26 17:15
 **/
public interface UserService {
    /**
     * 通过账号查找用户
     *
     * @param account
     * @return
     */
    public User findUserByAccount(String account);

    /**
     * 增加一个用户
     *
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 增加一条反馈记录
     *
     * @param feedback
     * @return
     */
    public boolean addFeedback(Feedback feedback);
}