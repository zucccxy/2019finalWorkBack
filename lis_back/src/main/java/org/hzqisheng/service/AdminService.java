package org.hzqisheng.service;

import org.lis_entity.Admin;
import org.lis_entity.ArticleResult;

import java.util.List;
import java.util.Map;

/**
 * 管理员service
 *
 * @Auther: cxy
 * @Date: 2018/12/11 10:16
 */

public interface AdminService {

    /**
     * 获取管理员列表
     *
     * @param adminPhone
     * @param adminName
     * @param adminState
     * @return
     */

    public List<Admin> findAdminList(String adminPhone, String adminName, Integer adminState);

    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
    public boolean addAdmin(Admin admin);

    /**
     * 修改管理员
     *
     * @param admin
     * @return
     */
    public boolean updateAdmin(Admin admin);

    /**
     * 查找单个管理员
     *
     * @param adminId
     * @return
     */
    public Admin findAdminById(Long adminId);

    /**
     * 通过手机号查询单个管理员
     *
     * @param adminPhone
     * @return
     */
    public Admin findAdminByPhone(String adminPhone);

    /**
     * 删除管理员
     *
     * @param adminId
     * @return
     */
    public boolean delAdmin(Long adminId);

    /**
     * 获取统计结果
     * @return
     */
    public Map<String,Long> getCount();

    /**
     * 获取所有文章
     */
    public List<ArticleResult> getArticleList();

    /**
     * 统计各文章
     * @return
     */
    public Map<String,Long> countCategoryName();
}
