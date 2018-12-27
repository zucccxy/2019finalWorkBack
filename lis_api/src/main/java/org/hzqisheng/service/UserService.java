package org.hzqisheng.service;

import org.lis_entity.User;

/**
 * @Author thlnkpad
 * @Date 2018/12/26 17:15
 **/
public interface UserService {
    /**
     * 通过账号查找用户
     * @param account
     * @return
     */
    public User findUserByAccount(String account);
}
