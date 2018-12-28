package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.ArticleService;
import org.lis_entity.Article;
import org.lis_entity.Category;
import org.lis_entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author thlnkpad
 * @Date 2018/12/27 16:46
 **/
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("api/article")
public class ArticleController {
    @Resource
    ArticleService articleService;

    /**
     * 获取标签列表
     * @return
     */
    @RequestMapping(value="categoryList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> categoryList(){
        List<Category> categoryListList=articleService.findCategoryList();
        log.info("用户注册------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList",categoryListList).
                build();
    }

    /**
     * 获取文章列表
     * @param pageIndex
     * @param pageSize
     * @param category
     * @return
     */
   @RequestMapping(value="articleList",method = RequestMethod.GET)
   @ResponseBody
    public Map<String,Object> articleList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "5") Integer pageSize,Category category){
        if(category.getCategoryId() == -1) {
            PageHelper.startPage(pageIndex, pageSize);
            List<Article> articleList = articleService.getArticleList();
            Page<Article> page = (Page<Article>) articleList;
            log.info("获取文章列表------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("dataList", articleList).
                    putData("pageIndex", pageIndex).
                    putData("pageSize", pageSize).
                    putData("totalCount", page.getTotal()).
                    build();
        }else{
            PageHelper.startPage(pageIndex, pageSize);
            List<Article> articleList=articleService.findArticleListByCategory(category.getCategoryId());
            Page<Article> page = (Page<Article>) articleList;
            log.info("获取文章列表------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("dataList", articleList).
                    putData("pageIndex", pageIndex).
                    putData("pageSize", pageSize).
                    putData("totalCount", page.getTotal()).
                    build();
       }
   }

    /**
     * 通过文章id查找文章
     * @param articleId
     * @return
     */
    @RequestMapping(value="articleDetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> articleDetail(@RequestParam Long articleId){
        Article article=articleService.findArticleListByArticleId(articleId);
        return  ResponseDataUtil.ok().
                putData("data",article).
                build();
    }
}
