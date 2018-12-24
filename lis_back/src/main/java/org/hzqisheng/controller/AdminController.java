package org.hzqisheng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.enums.ResponseCodeEnum;
import org.hzqisheng.service.AdminService;
import org.lis_entity.Admin;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.EnumState;
import org.util.MD5;
import org.util.StringUtil;
import org.util.response.ResponseDataUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cxy
 * @Date: 2018/12/11 10:12
 */
@Controller
@Scope("prototype")
@Slf4j
@RequestMapping("back/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    /**
     * 管理员列表
     *
     * @param session
     * @param pageIndex
     * @param pageSize
     * @param adminPhone
     * @param adminName
     * @param adminState
     * @return
     */

    @RequestMapping(value = "adminList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findAdminList(HttpSession session,
                                             @RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize,
                                             String adminPhone, String adminName, Integer adminState) {

        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        if (null == currAdmin) {
            return ResponseDataUtil.
                    fail(ResponseCodeEnum.NO_LOGIN).
                    build();
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<Admin> adminList = adminService.findAdminList(adminPhone, adminName, adminState);
        Page<Admin> page = (Page<Admin>) adminList;
        log.info("管理员列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("dataList", adminList).
                putData("pageIndex", pageIndex).
                putData("pageSize", pageSize).
                putData("totalCount", page.getTotal()).
                build();
    }

    /**
     * 根据id查找管理员
     *
     * @param session
     * @param adminId
     * @return
     */

    @RequestMapping(value = "findAdminById", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findAdminById(HttpSession session, Long adminId) {

        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        if (null == currAdmin) {
            return ResponseDataUtil.
                    fail(ResponseCodeEnum.NO_LOGIN).
                    build();
        }
        Admin admin = adminService.findAdminById(adminId);
        log.info("管理员列表查询------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("data", admin).
                build();
    }

    /**
     * 添加管理员
     *
     * @param session
     * @param admin
     * @return
     */

    @RequestMapping(value = "addAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addAdmin(HttpSession session, Admin admin) {
        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        if (null == currAdmin) {
            return ResponseDataUtil.
                    fail(ResponseCodeEnum.NO_LOGIN).
                    build();
        }

        if (currAdmin.getAdminLevel() != 0) {
            return ResponseDataUtil.
                    fail("您没有权限执行添加管理员!").
                    build();
        }
        if (null != adminService.findAdminByPhone(admin.getAdminPhone())) {
            return ResponseDataUtil.
                    fail("已有该账号的管理员!").
                    build();
        }

        MD5 md5 = new MD5();
        admin.setAdminPwd(md5.getStrToMD5(admin.getAdminPwd()));
        adminService.addAdmin(admin);
        log.info("新增管理员------------------------------------");
        return ResponseDataUtil.
                ok().
                putData("data", admin).
                build();


    }

    /**
     * 超级管理员修改管理员
     *
     * @param session
     * @param admin
     * @return
     */

    @RequestMapping(value = "updateAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateAdmin(HttpSession session, Admin admin) {
        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        if (null == currAdmin) {
            return ResponseDataUtil.
                    fail(ResponseCodeEnum.NO_LOGIN).
                    build();
        }

        if (currAdmin.getAdminLevel() != 0) {
            return ResponseDataUtil.
                    fail("您没有权限执行编辑管理员!").
                    build();
        }

        MD5 md5 = new MD5();
        admin.setAdminPwd(md5.getStrToMD5(admin.getAdminPwd()));

        log.info("更改管理员------------------------------------");
        if (adminService.updateAdmin(admin)) {
            return ResponseDataUtil.
                    ok().
                    putData("data", admin).
                    build();
        } else
            return ResponseDataUtil.
                    fail().
                    build();


    }

    /**
     * 删除管理员
     *
     * @param session
     * @param admin
     * @return
     */

    @RequestMapping(value = "delAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delAdmin(HttpSession session, Admin admin) {
        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        if (null == currAdmin) {
            return ResponseDataUtil.
                    fail(ResponseCodeEnum.NO_LOGIN).
                    build();
        }

        if (currAdmin.getAdminLevel() != 0) {
            return ResponseDataUtil.
                    fail("您没有权限删除管理员!").
                    build();
        }

        adminService.delAdmin(admin.getAdminId());
        log.info("删除管理员------------------------------------");

        return ResponseDataUtil.
                ok().
                build();


    }

    /**
     * 管理员登录
     *
     * @param adminPhone
     * @param adminPwd
     * @param session
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "logIn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logIn(String adminPhone, String adminPwd, HttpSession session) throws Exception {
        if (StringUtil.isBlank(adminPhone) || StringUtil.isBlank(adminPwd)) {
            return ResponseDataUtil.fail("账号密码不能为空！").build();
        }
        Admin admin = adminService.findAdminByPhone(adminPhone);
        if (null == admin) {
            return ResponseDataUtil.fail("账号不存在！").build();
        }
        if (admin.getAdminState().equals(EnumState.NO_USE)) {
            return ResponseDataUtil.fail("账号已被删除或冻结！").build();
        }
        MD5 md5 = new MD5();
        String md5Str = md5.getStrToMD5(adminPwd);
        log.info("管理员登录....................");
        if (admin.getAdminPwd().equals(md5Str)) {
            session.setAttribute("currAdmin", admin);
            return ResponseDataUtil.ok().putData("data", admin).build();
        } else {
            return ResponseDataUtil.fail("密码错误！").build();
        }
    }

    /**
     * 修改超级管理员密码
     * @param newPwd
     * @param oldPwd
     * @param session
     * @return
     */
    @RequestMapping(value="changePwd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changePwd(String newPwd,String oldPwd,HttpSession session){
        if(StringUtil.isBlank(newPwd)){
            return ResponseDataUtil.
                    fail("新密码不能为空！").
                    build();
        }
        if(StringUtil.isBlank(oldPwd)){
            return  ResponseDataUtil.
                    fail("旧密码不能为空！").
                    build();
        }
        Admin currAdmin = (Admin) session.getAttribute("currAdmin");
        MD5 md5=new MD5();
        String currAdminPassword=currAdmin.getAdminPwd();
        String oldPassword=md5.getStrToMD5(oldPwd);
        log.info("管理员密码修改....................");
        if(!currAdminPassword.equals(oldPassword)){
            return ResponseDataUtil.
                    fail("旧密码输入错误！").
                    build();
        }
        currAdmin.setAdminPwd(md5.getStrToMD5(newPwd));
        adminService.updateAdmin(currAdmin);


        return ResponseDataUtil.ok().build();
    }

    /**
     * 判断当前管理员是否登录
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping(value="checkLogin",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkLogin(Admin admin,HttpSession session){
        log.info("判断管理员是否登录");
        if(session.getAttribute("currAdmin")== null){
            return ResponseDataUtil.fail().build();
        }
        else{
            return ResponseDataUtil.ok().build();
        }
    }

    /**
     * 管理员退出登录
     * @param session
     * @return
     */
    @RequestMapping(value="logOut",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> logOut(HttpSession session){
        log.info("判断管理员是否登录");
        session.setAttribute("currAdmin",null);
        return ResponseDataUtil.ok().build();
    }

}
