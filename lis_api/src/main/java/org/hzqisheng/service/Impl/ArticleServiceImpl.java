package org.hzqisheng.service.Impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.CategoryDao;
import org.lis_entity.Category;
import org.lis_entity.CategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/27 16:42
 **/
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    CategoryDao categoryDao;
    @Override
    public List<Category> findCategoryList() {
        CategoryExample categoryExample=new CategoryExample();
        return categoryDao.selectByExample(categoryExample);
    }
}
