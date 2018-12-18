package org.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Import数据字典类别存储工具,根据String 找 Long
 * @author Administrator
 *
 */
public class ImportTypedataUtil {
	private static Map<String, Map<String, Long>> typedata=new HashMap<String, Map<String,Long>>();

	public static Map<String, Map<String, Long>> getTypedata() {
		return typedata;
	}

	public static void setTypedata(Map<String, Map<String, Long>> typedata) {
		ImportTypedataUtil.typedata = typedata;
	}
	
	/**
	 * 得到区域类型类别
	 * @return
	 */
	public static Map<String, Long> getRegiontype(){
		return typedata.get("regiontype");
	}
	
	/**
	 * 得到户/家庭类型类别
	 * @return
	 */
	public static Map<String, Long> getHouseholdtype(){
		return typedata.get("householdtype");
	}
	
	/**
	 * 得到楼栋类别
	 * @return
	 */
	public static Map<String, Long> getBuildtype(){
		return typedata.get("buildtype");
	}
	
	/**
	 * 得到民族类型
	 * @return
	 */
	public static Map<String, Long> getNation(){
		return typedata.get("nationtype");
	}

	/**
	 * 得到文化程度类型
	 * @return
	 */
	public static Map<String, Long> getEducation(){
		return typedata.get("education");
	}
	
	/**
	 * 得到婚姻状况类型
	 * @return
	 */
	public static Map<String, Long> getMarriage(){
		return typedata.get("marriage");
	}

	/**
	 * 得到政治面貌类型
	 * @return
	 */
	public static Map<String, Long> getPolitical(){
		return typedata.get("political");
	}
	
	/**
	 * 得到人户状态类型
	 * @return
	 */
	public static Map<String, Long> getHouseholdstatus(){
		return typedata.get("householdstatus");
	}
	
	/**
	 * 得到节育类型
	 * @return
	 */
	public static Map<String, Long> getBirthcontrol(){
		return typedata.get("birthcontrol");
	}
	
	/**
	 * 得到健康状况类型
	 * @return
	 */
	public static Map<String, Long> getHealthy(){
		return typedata.get("healthy");
	}
	
	/**
	 * 得到党派类型
	 * @return
	 */
	public static Map<String, Long> getParty(){
		return typedata.get("party");
	}
	
	/**
	 * 得到宗教类型
	 * @return
	 */
	public static Map<String, Long> getReligion(){
		return typedata.get("religion");
	}
	
	/**
	 * 得到管理类型
	 * @return
	 */
	public static Map<String, Long> getManagetype(){
		return typedata.get("managetype");
	}
	
	/**
	 * 得到农户性质类型
	 * @return
	 */
	public static Map<String, Long> getHomenature(){
		return typedata.get("homenature");
	}
	
	/**
	 * 得到身份类别类型
	 * @return
	 */
	public static Map<String, Long> getIdtype(){
		return typedata.get("idtype");
	}
	
	/**
	 * 得到残疾类别类型
	 * @return
	 */
	public static Map<String, Long> getDisabletype(){
		return typedata.get("disabletype");
	}
	
	/**
	 * 得到残疾等级类型
	 * @return
	 */
	public static Map<String, Long> getDisabletlevel(){
		return typedata.get("disablelevel");
	}
	
	/**
	 * 得到上访级别类型
	 * @return
	 */
	public static Map<String, Long> getPetitionlvl(){
		return typedata.get("petitionlvl");
	}
	
	/**
	 * 得到病情状况类型
	 * @return
	 */
	public static Map<String, Long> getMentalSts(){
		return typedata.get("mentalsts");
	}
	
	/**
	 * 得到优抚类别类型
	 * @return
	 */
	public static Map<String, Long> getSpecaretype(){
		return typedata.get("specaretype");
	}
	
	/**
	 * 得到优抚残疾等级类型
	 * @return
	 */
	public static Map<String, Long> getDeformityLevel(){
		return typedata.get("DeformityLevel");
	}
	
	/**
	 * 得到学习状况类型
	 * @return
	 */
	public static Map<String, Long> getStudystatus(){
		return typedata.get("studystatus");
	}
	
	
}
