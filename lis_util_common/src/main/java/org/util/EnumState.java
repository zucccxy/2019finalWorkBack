package org.util;



/**
 * 枚举状态类别
 * @author arron
 *
 */
public class EnumState {
	
	/**
	 * 表示肯定意思，存在，使用
	 */
	public static Integer USE = 1;
	
	/**
	 * 表示否定意思，不存在，不使用
	 */
	public static Integer NO_USE = 0;
	
	
	/**
	 * 表示删除
	 */
	public static Integer DEL = 2;
	
	/**
	 * 表示肯定意思，全部
	 */
	public static Integer ALL = -1;
    
	 /**
     * 统计类型
     * @author zhx
     *
     */
    public enum StatisticsType {

        // 利用构造函数传参
        DAY("日",1), MONTH("月",2), QUARTER("季度",3), YEAR("年",4);

        // 定义私有变量
        private int nCode;
        private String name;

        // 构造函数，枚举类型只能为私有
        private StatisticsType(String name , int _nCode) {
        	this.name = name;
            this.nCode = _nCode;
        }

        public Integer getState() {
            return this.nCode;
        }
        
        public String getName() {
            return this.name;
        }
    }
	
    /**
     * 订单类型
     * @author zhx
     *
     */
    public enum OrderType {

        // 利用构造函数传参
        WAIT("待支付",1), PAY("已支付",2), CANCEL("已撤销",3),;

        // 定义私有变量
        private int nCode;
        private String name;

        // 构造函数，枚举类型只能为私有
        private OrderType(String name , int _nCode) {
        	this.name = name;
            this.nCode = _nCode;
        }

        public Integer getState() {
            return this.nCode;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    /**
     * 接口类型
     * @author zhx
     *
     */
    public enum Interface {

        // 利用构造函数传参
        A("服务商品查询接口 ",1), B("检验所查询接口",2), C("下单接口",3), D("订单查询接口",4), E("订单撤销接口",5), F("物流查询接口",6);

        // 定义私有变量
        private long nCode;
        private String name;

        // 构造函数，枚举类型只能为私有
        private Interface(String name , long _nCode) {
        	this.name = name;
            this.nCode = _nCode;
        }

        public Long getState() {
            return this.nCode;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    /**
     * 操作类型
     * @author zhx
     *
     */
    public enum OperationType {

        // 利用构造函数传参
        A("新增 ",1), B("编辑",2), C("删除",3), D("冻结",4), E("解冻",5);

        // 定义私有变量
        private int nCode;
        private String name;

        // 构造函数，枚举类型只能为私有
        private OperationType(String name , int _nCode) {
        	this.name = name;
            this.nCode = _nCode;
        }

        public Integer getState() {
            return this.nCode;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    /**
     * 来源enum 1 lis系统  2 本地新增
     * 
     * @author HeFeiyu
     * @date 2018年9月18日
     */
    public enum Origin {
    	lis(1), local(2);
    	private int code;
    	
    	private Origin(int code) {
    		this.code = code;
    	}
    	
    	public int getCode() {
    		return this.code;
    	}
    }
    
}
