package org.hzqisheng.service.impl;

import org.hzqisheng.service.CategoryService;
import org.lis_dao.ArticleCategoryDao;
import org.lis_dao.CategoryDao;
import org.lis_entity.ArticleCategory;
import org.lis_entity.ArticleCategoryExample;
import org.lis_entity.Category;
import org.lis_entity.CategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/24 10:38
 **/
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryDao categoryDao;
    @Resource
    ArticleCategoryDao articleCategoryDao;

    @Override
    public List<Category> getCategoryList() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("category_name");
        return categoryDao.selectByExample(categoryExample);
    }

    @Override
    public List<Category> findCatergoryList(Long articleId) {

        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        ArticleCategoryExample.Criteria criteria = articleCategoryExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<ArticleCategory> articleCategoryList = articleCategoryDao.selectByExample(articleCategoryExample);
        if (articleCategoryList != null && articleCategoryList.size()!=0) {
            List<Category> categoryList = new ArrayList();
            for (ArticleCategory articleCategory : articleCategoryList) {
                Long categoryId = articleCategory.getCategoryId();
                Category category = categoryDao.selectByPrimaryKey(categoryId);
                categoryList.add(category);
            }
            return categoryList;
        } else {
            return null;
        }
    }
}

