package org.hzqisheng.service;

import org.lis_entity.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过userId获取收藏列表
     *
     * @param userId
     * @return
     */
    public List<CollectionResult> getCollectionResultListByUserId(Long userId);

    /**
     * 增加一条签到记录
     *
     * @param sign
     */
    public boolean addSign(Sign sign);

    /**
     * 统计用户签到天数
     *
     * @param userId
     * @return
     */
    public Long countSign(Long userId);

    /**
     * 判断用户是否可以签到
     * @param userId
     * @return
     */
    public Map<String,Object> judgeIsSign(Long userId);

    /**
     * 获取消息列表
     */
    public List<News> findNewsList(Long userId);

    /**
     * 获取未读消息
     * @param userId
     * @return
     */
    public Long  countUnReadNew(Long userId);

    /**
     * 更新消息状态
     * @param userId
     * @return
     */
    public boolean  updateNewStatus(Long userId);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public boolean  updateUser(User user);

    /**
     * 通过账户名查找用户
     * @param account
     * @return
     */
    public List<User> findUserByUserAccount(String account);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    public List<User> findUserByUsername(String username);

    /**
     * 删除消息
     * @param newsId
     * @return
     */
    public boolean deleteNews(Long newsId);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return
     */
    public User findUserByUserId(Long userId);

}