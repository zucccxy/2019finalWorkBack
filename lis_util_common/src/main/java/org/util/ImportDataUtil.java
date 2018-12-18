package org.util;

import java.util.HashMap;
import java.util.Map;


	/**
	 * Import数据字典类别存储工具 根据String找Long
	 * @author Administrator
	 *
	 */
	public class ImportDataUtil {
		private static Map<String, Map<String, Long>> typedata=new HashMap<String, Map<String,Long>>();

		public static Map<String, Map<String, Long>> getTypedata() {
			return typedata;
		}

		public static void setTypedata(Map<String, Map<String, Long>> typedata) {
			ImportDataUtil.typedata = typedata;
		}
		
		/**
		 * 得到楼栋类别
		 * @return
		 */
		public static Map<String, Long> getBuildclassify(){
			return typedata.get("buildclassify");
		}
		
		/**
		 * 得到车位规划用途类
		 * @return
		 */
		public static Map<String, Long> getCarplan(){
			return typedata.get("carplan");
		}
		
		/**
		 * 得到车位使用情况
		 * @return
		 */
		public static Map<String, Long> getCarUse(){
			return typedata.get("caruse");
		}
		
		
		/**
		 * 得到楼栋类型
		 * @return
		 */
		public static Map<String, Long> getBuildtype(){
			return typedata.get("buildtype");
		}

		/**
		 * 得到楼栋设计用途类型
		 * @return
		 */
		public static Map<String, Long> getBuilddesign(){
			return typedata.get("designuse");
		}
		
		/**
		 * 得到楼栋地址类型
		 * @return
		 */
		public static Map<String, Long> getBuildAddrType(){
			return typedata.get("addresstype");
		}
		
		/**
		 * 得到楼栋特殊类型
		 * @return
		 */
		public static Map<String, Long> getSpecialType(){
			return typedata.get("specialtype");
		}
		
		/**
		 * 得到楼栋使用用途类型
		 * @return
		 */
		public static Map<String, Long> getBuilduseway(){
			return typedata.get("buildusage");
		}
		
		/**
		 * 得到楼栋性质类型
		 * @return
		 */
		public static Map<String, Long> getBuildnature(){
			return typedata.get("buildnature");
		}
		
		/**
		 * 得到建筑类型
		 * @return
		 */
		public static Map<String, Long> getBuildbuildingtype(){
			return typedata.get("buildingtype");
		}
		
		/**
		 * 得到楼栋结构类型
		 * @return
		 */
		public static Map<String, Long> getBuildstructure(){
			return typedata.get("structuretype");
		}
		
		/**
		 * 得到与户主关系类型
		 * @return
		 */
		public static Map<String, Long> getHouserelation(){
			return typedata.get("houserelation");
		}
		
		/**
		 * 得到社会职务类型
		 * @return
		 */
		public static Map<String, Long> getSocialfunction(){
			return typedata.get("socialfunction");
		}
		
		/**
		 * 得到享受低保类型
		 * @return
		 */
		public static Map<String, Long> getLowtype(){
			return typedata.get("lowtype");
		}
		
		/**
		 * 得到外出务工类别类型
		 * @return
		 */
		public static Map<String, Long> getWorkouttype(){
			return typedata.get("workouttype");
		}
		
		/**
		 * 得到养老方式类型
		 * @return
		 */
		public static Map<String, Long> getSupportway(){
			return typedata.get("supportway");
		}
		
		/**
		 * 得到老人类别
		 * @return
		 */
		public static Map<String, Long> getSupporttype(){
			return typedata.get("supporttype");
		}
		
		/**
		 * 得到留守儿童学校类别
		 * @return
		 */
		public static Map<String, Long> getScholl(){
			return typedata.get("school");
		}
		
		/**
		 * 得到留守儿童类别
		 * @return
		 */
		public static Map<String, Long> getStudytype(){
			return typedata.get("studytype");
		}
		
		/**
		 * 得到矫正原因
		 * @return
		 */
		public static Map<String, Long> getPrbReason(){
			return typedata.get("PrbReason");
		}
		
		/**
		 * 得到矫正类别
		 * @return
		 */
		public static Map<String, Long> getPrbType(){
			return typedata.get("PrbType");
		}
		
		/**
		 * 得到处置情况
		 * @return
		 */
		public static Map<String, Long> getDrugDlSts(){
			return typedata.get("DrugDlSts");
		}
		
		/**
		 * 得到从业状况
		 * @return
		 */
		public static Map<String, Long> getDrugWorkSts(){
			return typedata.get("DrugWorkSts");
		}
		
		/**
		 * 得到当前状况
		 * @return
		 */
		public static Map<String, Long> getPrisonerNowSts(){
			return typedata.get("PrisonerNowSts");
		}
		
		/**
		 * 得到残疾性质
		 * @return
		 */
		public static Map<String, Long> getDeformity(){
			return typedata.get("Deformity");
		}
		/**
		 * 得到民族类型
		 * @return
		 */
		public static Map<String, Long> getNationtype(){
			return typedata.get("nationtype");
		}
		/**
		 * 得到受教育程度
		 * @return
		 */
		public static Map<String, Long> getEducation(){
			return typedata.get("education");
		}
		/**
		 * 得到政治面貌
		 * @return
		 */
		public static Map<String, Long> getPolitical(){
			return typedata.get("political");
		}
		/**
		 * 得到区域类型
		 * @return
		 */
		public static Map<String, Long> getRegiontype(){
			return typedata.get("regiontype");
		}
		/**
		 * 得到婚姻
		 * @return
		 */
		public static Map<String, Long> getMarriage(){
			return typedata.get("marriage");
		}
		/**
		 * 得到人户状态类型
		 * @return
		 */
		public static Map<String, Long> getHouseholdstatus(){
			return typedata.get("householdstatus");
		}
		/**
		 * 得到人户状态类型
		 * @return
		 */
		public static Map<String, Long> getBirthcontrol(){
			return typedata.get("birthcontrol");
		}
		/**
		 * 得到户/家庭类型类别
		 * @return
		 */
		public static Map<String, Long> getHouseholdtype(){
			return typedata.get("householdtype");
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
