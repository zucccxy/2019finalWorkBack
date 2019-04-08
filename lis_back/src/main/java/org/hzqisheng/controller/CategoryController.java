package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.CategoryService;
import org.lis_entity.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     *
     * @return
     */
    @RequestMapping(value = "categoryList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        log.info("获取标签列表------------------------------------");
        return ResponseDataUtil.ok()
                .putData("dataList", categoryList)
                .build();
    }

    /**
     * 通过博文id查找对应的标签
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "findCategoryList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findCategoryList(Long articleId) {
        List<Category> categoryList = categoryService.findCatergoryList(articleId);
        log.info("通过文章id获取标签列表------------------------------------");
        return ResponseDataUtil.ok()
                .putData("dataList", categoryList)
                .build();
    }

    /**
     * 博文标签列表
     *
     * @param pageIndex
     * @param pageSize
     * @param categoryName
     * @return
     */
    @RequestMapping(value = "getCategoryList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllCategoryList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                                  String categoryName) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Category> categoryList = categoryService.findCategoryListByCategoryName(categoryName);
        Page<Category> page = (Page<Category>) categoryList;
        log.info("博文标签列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", categoryList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 新增博文标签
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addCategory(Category category) {
        categoryService.addCategory(category);
        log.info("新增博文标签------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("data", category).
                build();
    }

    @RequestMapping(value = "updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateCategory(Category category) {
        if (categoryService.updateCategory(category)) {
            log.info("修改博文标签成功------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("data", category).
                    build();
        } else {
            log.info("修改博文标签失败------------------------------------");
            return ResponseDataUtil.
                    fail().
                    build();
        }
    }

    @RequestMapping(value = "delCategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delCategory(Long categoryId) {
        if (categoryService.deleteCategory(categoryId)) {
            log.info("删除标签成功------------------------------------");
            return ResponseDataUtil.
                    ok().
                    build();
        } else {
            log.info("删除标签失败------------------------------------");
            return ResponseDataUtil.
                    fail().
                    build();
        }

    }
}
