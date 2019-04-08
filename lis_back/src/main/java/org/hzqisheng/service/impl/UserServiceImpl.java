package org.hzqisheng.service.impl;

import org.lis_dao.*;
import org.lis_entity.*;

import org.hzqisheng.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/17 9:51
 **/
@Service("userService")
public class UserServiceImpl  implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    SignDao signDao;
    @Resource
    FeedbackDao feedbackDao;
    @Resource
    CollectionDao collectionDao;
    @Resource
    NewsDao newsDao;
    @Override
    public List<User> findUserList(String userAccount, String userName, Integer userLevel) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (null != userAccount && !"".equals(userAccount))
            criteria.andAccountLike("%" + userAccount + "%");
        if (null != userName && !"".equals(userName))
            criteria.andUsernameLike("%" + userName + "%");
        if (null != userLevel && userLevel >= 0) {
            criteria.andAuthorityEqualTo(userLevel);
        }
        userExample.setOrderByClause("username");
        return userDao.selectByExample(userExample);
    }

    @Override
    public boolean delUser(Long userId) {return userDao.deleteByPrimaryKey(userId) > 0; }

    @Override
    public boolean addUser(User user) {
        return userDao.insertSelective(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public List<SignResult> findSignList(String username, Date startTime, Date endTime) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("username",username);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return  userDao.selectNameAndSign(map);

}

    @Override
    public boolean delSign(Long signId) {

        return signDao.deleteByPrimaryKey(signId) > 0;
    }

    @Override
    public List<Feedback> findFeedbackList(String feedbackContent, Date startTime, Date endTime) {
       FeedbackExample feedbackExample=new FeedbackExample();
       FeedbackExample.Criteria criteria=feedbackExample.createCriteria();
       if(null != feedbackContent &&  !"".equals(feedbackContent)){
           criteria.andFeedbackContentLike("%"+feedbackContent+"%");
       }
       if(startTime != null ){
           criteria.andCreatTimeGreaterThanOrEqualTo(startTime);
       }
       if(endTime !=null){
           criteria.andCreatTimeLessThanOrEqualTo(endTime);
       }
       return feedbackDao.selectByExample(feedbackExample);
    }

    @Override
    public boolean delFeedback(Long feedbackId) {

        return feedbackDao.deleteByPrimaryKey(feedbackId) > 0;
    }

    @Override
    public List<CollectionResult> findCollectionResut(String username, String title, Date startTime, Date endTime) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("title",title);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return userDao.selectByCollectionCondition(map);
    }
    @Override
    public boolean delCollection(Long collectionId) {
        return collectionDao.deleteByPrimaryKey(collectionId) > 0;
    }

    @Override
    public List<NewsResult> findNewsResult(String username, Integer status, Date startTime, Date endTime) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("status",status);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return userDao.selectNewsByCollectionCondition(map);
    }

    @Override
    public boolean delNew(Long newsId) {
        return  newsDao.deleteByPrimaryKey(newsId) > 0;
    }
}
