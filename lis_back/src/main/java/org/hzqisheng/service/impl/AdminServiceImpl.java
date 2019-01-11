package org.hzqisheng.service.impl;

import org.hzqisheng.service.AdminService;
import org.lis_dao.*;
import org.lis_entity.*;
import org.springframework.stereotype.Service;
import org.util.StringUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cxy
 * @Date: 2018/12/11 10:31
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;
    @Resource
    ArticleDao articleDao;
    @Resource
    UserDao userDao;
    @Resource
    CommentDao commentDao;
    @Resource
    ReplayDao replayDao;
    @Resource
    CategoryDao categoryDao;
    @Resource
    ArticleCategoryDao articleCategoryDao;
    @Override
    public List<Admin> findAdminList(String adminPhone, String adminName, Integer adminState) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //判断每个搜索条件是否为空或者不合法，criteria用法不固定，可以像我这样用
        //example就是查询样板，样板有查询标准，每个实体类都有自己的example
        //意思就是给这个实体类的查询样板新建一个查询标准criteria，给这个标准添加查询条件，具体条件别和我说英文看不懂
        //最后以查询样板查询，查询标准只是规范这个样板的条件，样板可以set排序，分页和distinct。当然分页我们用的是插件。
        if (null != adminPhone && !"".equals(adminPhone))
            criteria.andAdminPhoneLike("%" + adminPhone + "%");
        if (null != adminName && !"".equals(adminName))
            criteria.andAdminNameLike("%" + adminName + "%");
        if (null != adminState && adminState >= 0)
            criteria.andAdminStateEqualTo(adminState);
        if (null == adminState || adminState < 0)
            criteria.andAdminStateNotEqualTo(2);
        adminExample.setOrderByClause("admin_name");
        return adminDao.selectByExample(adminExample);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.insertSelective(admin) > 0;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateByPrimaryKeySelective(admin) > 0;
    }

    @Override
    public Admin findAdminById(Long adminId) {
        return adminDao.selectByPrimaryKey(adminId);
    }

    @Override
    public Admin findAdminByPhone(String adminPhone) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (StringUtil.isBlank(adminPhone))
            return null;

        criteria.andAdminPhoneEqualTo(adminPhone);
        List<Admin> list = adminDao.selectByExample(adminExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean delAdmin(Long adminId) {
        Admin admin = adminDao.selectByPrimaryKey(adminId);
        admin.setAdminState(2);
        return adminDao.updateByPrimaryKeySelective(admin) > 0;
    }

    @Override
    public Map<String, Long> getCount() {
        Map<String,Long> countResult=new HashMap<>();
        ArticleExample articleExample=new ArticleExample();
        countResult.put("articleNumber",articleDao.countByExample(articleExample));
        UserExample userExample=new UserExample();
        countResult.put("userNumber",userDao.countByExample(userExample));
        CommentExample commentExample=new CommentExample();
        countResult.put("commentNumber",commentDao.countByExample(commentExample));
        ReplayExample replayExample=new ReplayExample();
        countResult.put("replyNumber",replayDao.countByExample(replayExample));
        return countResult;
    }

    @Override
    public List<ArticleResult> getArticleList() {
        return articleDao.selectAllArticleResultList();
    }
    @Override
    public Map<String, Long> countCategoryName() {
        Map<String,Long> countResult=new HashMap<>();
        CategoryExample categoryExample=new CategoryExample();
        List<Category> categoryList=categoryDao.selectByExample(categoryExample);
        for(Category category :categoryList){
            ArticleCategoryExample articleCategoryExample=new ArticleCategoryExample();
            ArticleCategoryExample.Criteria criteria=articleCategoryExample.createCriteria();
            criteria.andCategoryIdEqualTo(category.getCategoryId());
            countResult.put(category.getCategoryName(),articleCategoryDao.countByExample(articleCategoryExample));
        }
        return countResult;
    }
}
