package org.hzqisheng.service.impl;

import org.hzqisheng.service.AdminService;
import org.lis_dao.AdminDao;
import org.lis_entity.Admin;
import org.lis_entity.AdminExample;
import org.springframework.stereotype.Service;
import org.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cxy
 * @Date: 2018/12/11 10:31
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public List<Admin> findAdminList(String adminPhone, String adminName, Integer adminState) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //判断每个搜索条件是否为空或者不合法，criteria用法不固定，可以像我这样用
        //example就是查询样板，样板有查询标准，每个实体类都有自己的example
        //意思就是给这个实体类的查询样板新建一个查询标准criteria，给这个标准添加查询条件，具体条件别和我说英文看不懂
        //最后以查询样板查询，查询标准只是规范这个样板的条件，样板可以set排序，分页和distinct。当然分页我们用的是插件。
        if (null != adminPhone && !"".equals(adminPhone))
            criteria.andAdminPhoneLike("%" + adminPhone + "%");
        if (null != adminName && !"".equals(adminName))
            criteria.andAdminNameLike("%" + adminName + "%");
        if (null != adminState && adminState >= 0)
            criteria.andAdminStateEqualTo(adminState);
        if (null == adminState || adminState < 0)
            criteria.andAdminStateNotEqualTo(2);
        adminExample.setOrderByClause("admin_name");
        return adminDao.selectByExample(adminExample);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.insertSelective(admin) > 0;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateByPrimaryKeySelective(admin) > 0;
    }

    @Override
    public Admin findAdminById(Long adminId) {
        return adminDao.selectByPrimaryKey(adminId);
    }

    @Override
    public Admin findAdminByPhone(String adminPhone) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (StringUtil.isBlank(adminPhone))
            return null;

        criteria.andAdminPhoneEqualTo(adminPhone);
        List<Admin> list = adminDao.selectByExample(adminExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean delAdmin(Long adminId) {
        Admin admin = adminDao.selectByPrimaryKey(adminId);
        admin.setAdminState(2);
        return adminDao.updateByPrimaryKeySelective(admin) > 0;
    }
}
