package org.hzqisheng.service;

import org.lis_entity.User;

import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/17 9:49
 **/
public interface UserService {
    /**
     * 获取用户列表
     * @param adminPhone
     * @param adminName
     * @param adminState
     * @return
     */
    public List<User> findUserList(String adminPhone, String adminName, Integer adminState);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public  boolean delUser(Long userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public  boolean addUser(User user);

    public  boolean updateUser(User user);

}
