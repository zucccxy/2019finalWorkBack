package org.hzqisheng.service.Impl;

import org.hzqisheng.service.UserService;
import org.lis_dao.FeedbackDao;
import org.lis_dao.NewsDao;
import org.lis_dao.SignDao;
import org.lis_dao.UserDao;
import org.lis_entity.*;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.util.DateUtil;
import org.util.StringUtil;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    SignDao signDao;
    @Resource
    NewsDao newsDao;
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

    @Override
    public List<CollectionResult> getCollectionResultListByUserId(Long userId) {
        return userDao.selectAllCollectionResultByUserId(userId);
    }

    @Override
    public boolean addSign(Sign sign) {
        sign.setSignTime(new Date());
        return signDao.insertSelective(sign) > 0;
    }

    @Override
    public Long countSign(Long userId) {
        SignExample signExample=new SignExample();
        SignExample.Criteria criteria=signExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return signDao.countByExample(signExample);
    }

    @Override
    public Map<String,Object> judgeIsSign(Long userId) {
        Map<String,Object> resultMap=new HashMap<>();
        SignExample signExample=new SignExample();
        SignExample.Criteria criteria=signExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andSignTimeGreaterThanOrEqualTo(DateUtil.getCurrentDay());
        try {
            criteria.andSignTimeLessThanOrEqualTo(DateUtil.getTodayfinish(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Sign> signList=signDao.selectByExample(signExample);
        if(signList.size() == 0){
            resultMap.put("result",true);
            resultMap.put("resultData","");
            return resultMap;
        }else {
            resultMap.put("result",false);
            resultMap.put("resultData",signList);
            return resultMap;
        }
    }

    @Override
    public List<News> findNewsList(Long userId) {
        NewsExample newsExample=new NewsExample();
        NewsExample.Criteria criteria=newsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return newsDao.selectByExample(newsExample);
    }

    @Override
    public Long countUnReadNew(Long userId) {
        NewsExample newsExample=new NewsExample();
        NewsExample.Criteria criteria=newsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(0);
        return newsDao.countByExample(newsExample);
    }

    @Override
    public boolean updateNewStatus(Long userId) {
        NewsExample newsExample=new NewsExample();
        NewsExample.Criteria criteria=newsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(0);
        News news=new News();
        news.setStatus(1);
        return  newsDao.updateByExampleSelective(news,newsExample) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public List<User> findUserByUserAccount(String account) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        return userDao.selectByExample(userExample);
    }

    @Override
    public List<User> findUserByUsername(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria  criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userDao.selectByExample(userExample);
    }

    @Override
    public boolean deleteNews(Long newsId) {
        return newsDao.deleteByPrimaryKey(newsId) > 0;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
