package org.hzqisheng.service;

import org.lis_entity.CollectionResult;
import org.lis_entity.Feedback;
import org.lis_entity.Sign;
import org.lis_entity.User;

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
}