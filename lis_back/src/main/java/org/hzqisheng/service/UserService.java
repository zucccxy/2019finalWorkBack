package org.hzqisheng.service;

import org.lis_entity.CollectionResult;
import org.lis_entity.FeedbackResult;
import org.lis_entity.SignResult;
import org.lis_entity.User;

import java.util.Date;
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

    /**
     * 修改用户
     * @param user
     * @return
     */
    public  boolean updateUser(User user);
    /**
     * 获取签到列表
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    public List<SignResult>  findSignList(String username, Date startTime, Date endTime);

    /**
     * 删除签到记录
     * @param signId
     * @return
     */
    public boolean delSign(Long signId);

    /**
     * 获取反馈列表
     * @param username
     * @param startTime
     * @param endTime
     * @return
     */
    public List<FeedbackResult> findFeedbackList(String username,Date startTime,Date endTime);

    /**
     * 删除反馈记录
     * @param feedbackId
     * @return
     */
    public boolean  delFeedback(Long feedbackId);

    /**
     * 获取收藏列表
     * @param username
     * @param title
     * @param startTime
     * @param endTime
     * @return
     */
    public List<CollectionResult> findCollectionResut(String username,String title,Date startTime,Date endTime);

    /**
     * 删除收藏记录
     * @param collectionId
     * @return
     */
    public boolean delCollection(Long  collectionId);
}
