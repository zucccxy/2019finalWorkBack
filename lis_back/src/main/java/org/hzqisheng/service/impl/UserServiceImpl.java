package org.hzqisheng.service.impl;

import org.lis_entity.User;
import org.lis_entity.UserExample;

import org.hzqisheng.service.UserService;
import org.springframework.stereotype.Service;
import org.lis_dao.UserDao;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/17 9:51
 **/
@Service("userService")
public class UserServiceImpl  implements UserService {
    @Resource
    UserDao userDao;

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
    public boolean delUser(Long userId) {
        return userDao.deleteByPrimaryKey(userId) > 0;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.insertSelective(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }
}
