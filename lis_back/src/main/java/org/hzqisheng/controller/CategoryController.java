package org.hzqisheng.controller;

import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.CategoryService;
import org.lis_entity.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.smartcardio.CardTerminal;
import java.util.List;
import java.util.Map;

/**
 * @Author thlnkpad
 * @Date 2018/12/24 10:46
 **/
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("back/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    /**
     * 获取标签列表
     * @return
     */
    @RequestMapping(value="categoryList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCategoryList(){
        List<Category> categoryList=categoryService.getCategoryList();
        log.info("获取标签列表------------------------------------");
        return ResponseDataUtil.ok()
                .putData("dataList",categoryList)
                .build();
     }

    /**
     * 通过博文id查找对应的标签
     * @param articleId
     * @return
     */
     @RequestMapping(value="findCategoryList",method=RequestMethod.GET)
     @ResponseBody
     public Map<String,Object> findCategoryList(Long  articleId){
        List<Category> categoryList=categoryService.findCatergoryList(articleId);
         log.info("通过文章id获取标签列表------------------------------------");
         return ResponseDataUtil.ok()
                 .putData("dataList",categoryList)
                 .build();
     }
}
