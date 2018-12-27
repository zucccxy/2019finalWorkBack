package org.hzqisheng.controller;

import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.ArticleService;
import org.lis_entity.Category;
import org.lis_entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
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
}
