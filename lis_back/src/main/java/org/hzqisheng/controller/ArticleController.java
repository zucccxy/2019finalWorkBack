package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.ArticleService;
import org.lis_entity.Article;
import org.lis_entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author thlnkpad
 * @Date 2018/12/19 10:04
 **/
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("back/article")
public class ArticleController {
    @Resource
    ArticleService articleService;

    @RequestMapping(value="articleList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  findArticleList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                               String title, String expect, String author, Date startTime, Date endTime){
            PageHelper.startPage(pageIndex, pageSize);
            List<Article> articleList = articleService.findArticleList(title,expect,author,startTime,endTime);
            Page<Article> page = (Page<Article>) articleList;
            log.info("博文列表查询------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("dataList", articleList).
                    putData("pageIndex", pageIndex).
                    putData("pageSize", pageSize).
                    putData("totalCount", page.getTotal()).
                    build();
    }
}
