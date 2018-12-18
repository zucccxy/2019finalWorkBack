package org.util;

import java.util.HashMap;
import java.util.Map;


/**
 * 数据字典类别存储工具
 * @author Administrator
 *
 */
public class TypedataUtil {
	//投资的key值
	public static Long touzi = (long) 2;
	
	private static Map<String, Map<String, String>> typedata=new HashMap<String, Map<String,String>>();

	public static Map<String, Map<String, String>> getTypedata() {
		return typedata;
	}

	public static void setTypedata(Map<String, Map<String, String>> typedata) {
		TypedataUtil.typedata = typedata;
	}
	
	/**
     * 个人权限字典
     */
    private static Map<String, Map<String, Boolean>> permissiondata = new HashMap<String, Map<String, Boolean>>();
	
//	private static Map<String, List<DataDet>> colunmData=new HashMap<String, List<DataDet>>();
//	
//	public static Map<String, List<DataDet>> getColunmData() {
//		return colunmData;
//	}
//	public static void setColunmData(Map<String, List<DataDet>> colunmData) {
//		TypedataUtil.colunmData = colunmData;
//	}
	/**
	 * 得到后台权限
	 * @return
	 */
	public static Map<String,String> getPermissionBack(){
		return typedata.get("permissionBack");
	}
	
	/**
	 * 得到前台权限
	 * @return
	 */
	public static Map<String,String> getPermissionFront(){
		return typedata.get("permissionFront");
	}
	
	/**
	 * 得到流水备注
	 * @return
	 */
	public static Map<String,String> getAccountFlow(){
		return typedata.get("account_flow");
	}
	
	public static Map<String,String> getOperation(){
		return typedata.get("operation_remark");
	}
	
	/**
	 * 得到短信模板
	 * @return
	 */
	public static Map<String,String> getMessage(){
		return typedata.get("message");
	}

    public static Map<String, Map<String, Boolean>> getPermissiondata() {
        return permissiondata;
    }

    public static void setPermissiondata(Map<String, Map<String, Boolean>> permissiondata) {
        TypedataUtil.permissiondata = permissiondata;
    }
	
	
	
//	/**
//	 * 得到栏目
//	 * @return
//	 */
//	public static List<DataDet> getColumn(){
//		return colunmData.get("column");
//	}
	
	
	
}


