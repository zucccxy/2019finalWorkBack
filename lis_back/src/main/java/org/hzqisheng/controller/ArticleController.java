package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.hzqisheng.service.ArticleService;
import org.lis_entity.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    /**
     * 获取文章列表
     * @param pageIndex
     * @param pageSize
     * @param title
     * @param expect
     * @param author
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="articleList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  findArticleList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                               String title, String expect, String author, Date startTime, Date endTime){
            PageHelper.startPage(pageIndex, pageSize);
            List<ArticleResult> articleList = articleService.findArticleList(title,expect,author,startTime,endTime);
            Page<ArticleResult> page = (Page<ArticleResult>) articleList;
            log.info("博文列表查询------------------------------------");
            return ResponseDataUtil.
                    ok().
                    putData("dataList", articleList).
                    putData("pageIndex", pageIndex).
                    putData("pageSize", pageSize).
                    putData("totalCount", page.getTotal()).
                    build();
    }

    /**
     * 新增文章
     * @param article
     * @param categoryIds
     * @return
     */
    @RequestMapping(value="addArticle",method =RequestMethod.POST)
    @ResponseBody
        public Map<String,Object> addArticle(HttpSession session,Article article, Long[] categoryIds){
        Admin currentAdim=(Admin)session.getAttribute("currAdmin");
        Long adminId=currentAdim.getAdminId();
        articleService.addArticle(adminId,article,categoryIds);
        log.info("新增博文------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

    /**
     * 编辑博文
     * @param article
     * @param categoryIds
     * @return
     */
    @RequestMapping(value="updateArticle",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateArticle(Article article,Long[] categoryIds){
        articleService.updateArticle(article,categoryIds);
        log.info("编辑博文------------------------------------");
        return ResponseDataUtil
                .ok()
                .build();
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @RequestMapping(value="delArticle",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delArticle(Long articleId){
       if(articleService.delArticle(articleId)) {
           log.info("删除文章成功------------------------------------");
           return ResponseDataUtil.
                   ok().
                   build();
       }else{
           log.info("删除文章失败------------------------------------");
           return ResponseDataUtil.
                   fail().
                   build();
       }
    }
    /**
     * 评论列表
     * @param pageIndex
     * @param pageSize
     * @param username
     * @param title
     * @param commentContent
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="commentList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findCommentList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                                String username,String title,String commentContent ,Date startTime,Date endTime) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CommentResult> commentList = articleService.findCommentList(username, title,commentContent,startTime, endTime);
        Page<CommentResult> page = (Page<CommentResult>) commentList;
        log.info("评论列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", commentList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @RequestMapping(value="delComment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delComment(Long commentId){
        articleService.delComment(commentId);
        log.info("删除评论------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }


    /**
     * 获取回复列表
     * @param pageIndex
     * @param pageSize
     * @param commentId
     * @param username
     * @param replyContent
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="replayList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findCommentList(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam(required=true) Long commentId,String username,String replyContent,Date startTime,Date endTime) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ReplayResult> replayList = articleService.findReplayResult(commentId,username,replyContent,startTime, endTime);
        Page<ReplayResult> page = (Page<ReplayResult>) replayList;
        log.info("回复列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", replayList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    @RequestMapping(value="delReplay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delReplay(Long replyId){
        articleService.delRepaly(replyId);
        log.info("删除回复------------------------------------");
        return ResponseDataUtil.
                ok().
                build();
    }

}
