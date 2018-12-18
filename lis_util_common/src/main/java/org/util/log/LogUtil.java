package org.util.log;

/**
 * 操作日志
 * @author Administrator
 *
 */
public class LogUtil {
    /**
     * 登录登出
     * @param adminRealName
     * @param flag1:1/登录 2/退出登录
     * @param userRealName
     * @param userStateStr
     * @return
     */
    public static String operateLogin(String adminRealName,Integer flag) {
        String remark = "后台管理员【"+adminRealName+"】进行了";
        switch (flag) {
        case 1:
            remark += "登录";
            break;
        case 2:
            remark += "退出登录";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    
    /**
     * 操作系统信息（含管理员）
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateAdmin(String adminRealName,Integer flag,String roleNames,String newAdmin) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "对平台基础设置进行了编辑操作";
            break;
        case 2:
            remark += "新增了【"+roleNames+"】角色的管理员【"+newAdmin+"】";
            break;
        case 3:
            remark += "对【"+newAdmin+"】进行了编辑操作";
            break;
        case 4:
            remark += "对【"+newAdmin+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 操作商品
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateCommodity(String adminRealName,Integer flag,String commodityName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "添加了平台自营商品【"+commodityName+"】";
            break;
        case 2:
            remark += "对平台自营商品【"+commodityName+"】进行了上架操作";
            break;
        case 3:
            remark += "对平台自营商品【"+commodityName+"】进行了下架操作";
            break;
        case 4:
            remark += "对平台自营商品【"+commodityName+"】进行了推荐操作";
            break;
        case 5:
            remark += "对平台自营商品【"+commodityName+"】进行了取消推荐操作";
            break;
        case 6:
            remark += "对平台自营商品【"+commodityName+"】进行了排序权重编辑操作";
            break;
        case 7:
            remark += "对平台自营商品【"+commodityName+"】进行了编辑操作";
            break;
        case 8:
            remark += "对平台自营商品【"+commodityName+"】进行了删除操作 ";
            break;
        case 9:
            remark += "对入驻商品【"+commodityName+"】进行了上架操作";
            break;
        case 10:
            remark += "对入驻商品【"+commodityName+"】进行了下架操作";
            break;
        case 11:
            remark += "对入驻商品【"+commodityName+"】进行了推荐操作";
            break;
        case 12:
            remark += "对入驻商品【"+commodityName+"】进行了取消推荐操作";
            break;
        case 13:
            remark += "对入驻商品【"+commodityName+"】进行了排序权重编辑操作";
            break;
        case 14:
            remark += "对入驻商品【"+commodityName+"】进行了编辑操作";
            break;
        case 15:
            remark += "对入驻商品【"+commodityName+"】进行了删除操作";
            break;
        case 16:
            remark += "对入驻商品【"+commodityName+"】进行了通过审核操作";
            break;
        case 17:
            remark += "对入驻商品【"+commodityName+"】进行了不通过审核操作";
            break;
        case 18:
            remark += "对商品【"+commodityName+"】进行了取消预警操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 商品分类
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateCommodityType(String adminRealName,Integer flag,String typename) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了商品类分类【"+typename+"】";
            break;
        case 2:
            remark += "新增了服务类类分类【"+typename+"】";
            break;
        case 3:
            remark += "对商品类分类【"+typename+"】进行了编辑操作";
            break;
        case 4:
            remark += "对商品类分类【"+typename+"】进行了删除操作";
            break;
        case 5:
            remark += "对服务类分类【"+typename+"】进行了编辑操作";
            break;
        case 6:
            remark += "对服务类分类【"+typename+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 操作订单
     * @param adminRealName
     * @param flag
     * @param rentInfoId
     * @return
     */
    public static String operateOrder(String adminRealName,Integer flag,String orderNumber,String commodityName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "对订单编号【"+orderNumber+"】的入驻商品【"+commodityName+"】的【买家评论】评论进行了回复";
            break;
        case 2:
            remark += "对订单编号【"+orderNumber+"】的平台自营商品【"+commodityName+"】的【买家评论】评论进行了回复";
            break;
        case 3:
            remark += "对订单编号【"+orderNumber+"】的入驻商品【"+commodityName+"】的【商家评论】进行了回复操作";
            break;
        case 4:
            remark += "对订单编号【"+orderNumber+"】的平台自营商品【"+commodityName+"】的【商家评论】进行了回复操作";
            break;
        case 5:
            remark += "对订单编号【"+orderNumber+"】的订单评论进行了删除操作";
            break;
        case 6:
            remark += "对入驻商品【"+commodityName+"】进行了新增【商家评论】操作";
            break;
        case 7:
            remark += "对平台自营商品【"+commodityName+"】进行了新增【商家评论】操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 发货退款
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateDelivery(String adminRealName,Integer flag,String orderNumber) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "对订单编号【"+orderNumber+"】进行了发货操作";
            break;
        case 2:
            remark += "对订单编号【"+orderNumber+"】的【仅退款】进行了处理，处理结果为【已通过】";
            break;
        case 3:
            remark += "对订单编号【"+orderNumber+"】的【仅退款】进行了处理，处理结果为【已拒绝】";
            break;
        case 4:
            remark += "对订单编号【"+orderNumber+"】的【退款退货】进行了处理，处理结果为【已通过】";
            break;
        case 5:
            remark += "对订单编号【"+orderNumber+"】的【退款退货】进行了处理，处理结果为【已拒绝】";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 横幅banner
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateBanner(String adminRealName,Integer flag,String bannerName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了banner【"+bannerName+"】";
            break;
        case 2:
            remark += "对banner【"+bannerName+"】进行了排序操作";
            break;
        case 3:
            remark += "对banner【"+bannerName+"】进行了显示操作";
            break;
        case 4:
            remark += "对banner【"+bannerName+"】进行了取消显示操作";
            break;
        case 5:
            remark += "对banner【"+bannerName+"】进行了编辑操作";
            break;
        case 6:
            remark += "对banner【"+bannerName+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 文章
     * @param adminRealName
     * @param flag
     * @param msgId
     * @return
     */
    public static String operateArticle(String adminRealName,Integer flag,String articleName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了文章【"+articleName+"】";
            break;
        case 2:
            remark += "对文章【"+articleName+"】进行了排序操作";
            break;
        case 3:
            remark += "对文章【"+articleName+"】进行了显示操作";
            break;
        case 4:
            remark += "对文章【"+articleName+"】进行了取消显示操作";
            break;
        case 5:
            remark += "对文章【"+articleName+"】进行了编辑操作";
            break;
        case 6:
            remark += "对文章【"+articleName+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 专题
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateSpecial(String adminRealName,Integer flag,String specialName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了专题【"+specialName+"】";
            break;
        case 2:
            remark += "对专题【"+specialName+"】进行了排序操作";
            break;
        case 3:
            remark += "对专题【"+specialName+"】进行了显示操作";
            break;
        case 4:
            remark += "对专题【"+specialName+"】进行了取消显示操作";
            break;
        case 5:
            remark += "对专题【"+specialName+"】进行了编辑操作";
            break;
        case 6:
            remark += "对专题【"+specialName+"】进行了删除操作";
            break;
        case 7:
        remark += "对专题【"+specialName+"】进行了推荐操作";
        	break;
        case 8:
            remark += "对专题【"+specialName+"】进行了取消推荐操作";
            	break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 活动
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateActivity(String adminRealName,Integer flag,String activityName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了活动【"+activityName+"】";
            break;
        case 2:
            remark += "对活动【"+activityName+"】进行了排序操作";
            break;
        case 3:
            remark += "对活动【"+activityName+"】进行了上线操作";
            break;
        case 4:
            remark += "对活动【"+activityName+"】进行了下线操作";
            break;
        case 5:
            remark += "对活动【"+activityName+"】进行了编辑操作";
            break;
        case 6:
            remark += "对活动【"+activityName+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 入驻店铺
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateStore(String adminRealName,Integer flag,String storeName) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "添加入驻商【"+storeName+"】";
            break;
        case 2:
            remark += "对入驻商【"+storeName+"】进行了编辑操作";
            break;
        case 3:
            remark += "对入驻商【"+storeName+"】进行了暂停营业操作";
            break;
        case 4:
            remark += "对入驻商【"+storeName+"】进行了取消暂停营业操作";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
    
    /**
     * 运费模板
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateFreight(String adminRealName,Integer flag,String freight) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "新增了运费模板【"+freight+"】";
            break;
        case 2:
            remark += "对运费模板【"+freight+"】进行了编辑操作 ";
            break;
        case 3:
            remark += "对运费模板【"+freight+"】进行了删除操作";
            break;
        default:
            remark = "";
            break; 
        }
        return remark;
    }
    
    /**
     * 平台流水
     * @param adminRealName
     * @param flag
     * @return
     */
    public static String operateData(String adminRealName,Integer flag,String storeName,String season,String year) {
        String remark = "后台管理员【"+adminRealName+"】";
        switch (flag) {
        case 1:
            remark += "对平台流水明细进行了导出列表的操作";
            break;
        case 2:
            remark += "对【"+year+"】【"+storeName+"】的【"+season+"】商家结算进行了导出列表的操作 ";
            break;
        default:
            remark = "";
            break; 
        }
       
        return remark;
    }
}
