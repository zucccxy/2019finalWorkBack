package org.util.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.util.DateUtil;

public class ExcelUtil {

//	/**
//	 * 检验结果分析导出
//	 *
//	 * @param request
//	 * @param response
//	 * @param result
//	 * @param startDate
//	 * @param endDate
//	 * @throws Exception
//	 * @author HeFeiyu
//	 * @date 2018年9月25日
//	 */
//	public static void analysisResultExport(Integer type, HttpServletRequest request, HttpServletResponse response,
//			List<SampleAnalysis> result, Date startDate, Date endDate) throws Exception {
//		List<Object[]> list = new ArrayList<>();
//		if (result != null && result.size() > 0) {
//			for (SampleAnalysis sa : result) {
//				Object[] obj = new Object[4];
//				obj[0] = sa.getTime() + (type == 1 ? "日" : type == 2 ? "月" : "年");
//				obj[1] = sa.getExpertTimes();
//				obj[2] = sa.getReportSum();
//				obj[3] = sa.getRate();
//				list.add(obj);
//			}
//			String[] title = { "时间", "实验次数", "阳性报告数量", "阳性率" };
//			ExportExeclUtil.export("检验结果分析", "检验结果分析", title, list, request, response, startDate, endDate);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//	}
//
//	/**
//	 * 质控项目导出excel
//	 *
//	 * @param request
//	 * @param response
//	 * @param qualityControlList
//	 * @throws Exception
//	 * @author sz
//	 */
//	public static void QualityControlListToExport(HttpServletRequest request, HttpServletResponse response,
//			List<QualityControl> qualityControlList) throws Exception {
//		List<Object[]> list = new ArrayList<Object[]>();
//		if (null != qualityControlList && qualityControlList.size() > 0) {
//			for (QualityControl qualityControl : qualityControlList) {
//				Object data[] = new Object[9];
//				data[0] = qualityControl.getQcIoName() == null ? "" : qualityControl.getQcIoName();
//				data[1] = qualityControl.getQcName() == null ? "" : qualityControl.getQcName();
//				data[2] = qualityControl.getQcNum() == null ? "" : qualityControl.getQcNum();
//				data[3] = qualityControl.getQcWavelength() == null ? "" : qualityControl.getQcWavelength();
//				data[4] = qualityControl.getQcCv() == null ? "" : qualityControl.getQcCv();
//				data[5] = qualityControl.getQcMethod() == null ? "" : qualityControl.getQcMethod();
//				data[6] = qualityControl.getQualityControlTargetValue() == null ? ""
//						: qualityControl.getQualityControlTargetValue();
//				data[7] = qualityControl.getQualityControlSd() == null ? "" : qualityControl.getQualityControlSd();
//				data[8] = qualityControl.getQualityControlResultValue() == null ? ""
//						: qualityControl.getQualityControlResultValue();
//				list.add(data);
//			}
//			String[] title = { "检验所名称", "质控项目名称", "质控项目编号", "使用波长", "目标CV", "实验方法", "靶值", "SD标准差", "结果值" };
//			ExportExeclUtil.export("质控项目表", "质控项目表", title, list, request, response, null, null);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//	}
//
//	/**
//	 * 质控项目结果导出excel
//	 *
//	 * @param request
//	 * @param response
//	 * @param qualityControlResultList
//	 * @throws Exception
//	 * @author sz
//	 */
//	public static void QualityControlResultListToExport(HttpServletRequest request, HttpServletResponse response,
//			List<QualityControlResult> qualityControlResultList) throws Exception {
//		List<Object[]> list = new ArrayList<Object[]>();
//		if (null != qualityControlResultList && qualityControlResultList.size() > 0) {
//			for (QualityControlResult qualityControlResult : qualityControlResultList) {
//				Object data[] = new Object[8];
//				data[0] = qualityControlResult.getQualityControlIoName() == null ? ""
//						: qualityControlResult.getQualityControlIoName();
//				data[1] = qualityControlResult.getQcPpName() == null ? "" : qualityControlResult.getQcPpName();
//				data[2] = qualityControlResult.getQualityControlName() == null ? ""
//						: qualityControlResult.getQualityControlName();
//				data[3] = qualityControlResult.getQualityControlNum() == null ? ""
//						: qualityControlResult.getQualityControlName();
//				data[4] = qualityControlResult.getQualityControlTargetValue() == null ? ""
//						: qualityControlResult.getQualityControlTargetValue();
//				data[5] = qualityControlResult.getQualityControlSd() == null ? ""
//						: qualityControlResult.getQualityControlSd();
//				data[6] = qualityControlResult.getQualityControlTestTimes() == null ? ""
//						: qualityControlResult.getQualityControlTestTimes();
//				data[7] = qualityControlResult.getQualityControlResultValue() == null ? ""
//						: qualityControlResult.getQualityControlResultValue();
//				list.add(data);
//			}
//			String[] title = { "检验所名称", "检验项目名称", "质控项目名称", "质控项目编号", "靶值", "SD标准差", "实验次数", "结果值" };
//			ExportExeclUtil.export("质控项目结果表", "质控项目结果表", title, list, request, response, null, null);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//
//	}
//
//	/**
//	 * 服务项目数据分析 导出excel
//	 *
//	 * @param type
//	 * @param request
//	 * @param response
//	 * @param result
//	 * @param startDate
//	 * @param endDate
//	 * @throws Exception
//	 * @author czx
//	 * @时间 2018年9月27日 上午8:53:37
//	 */
//	public static void servicesAnalysisResultExport(Integer type, HttpServletRequest request,
//			HttpServletResponse response, List<ServicesAvailableAnalysis> result, Date startDate, Date endDate)
//			throws Exception {
//		List<Object[]> list = new ArrayList<>();
//		if (result != null && result.size() > 0) {
//			for (ServicesAvailableAnalysis saa : result) {
//				Object[] obj = new Object[4];
//				obj[0] = saa.getTime() + (type == 1 ? "日" : type == 2 ? "月" : "年");
//				obj[1] = saa.getOrderNum();
//				obj[2] = saa.getLabNum();
//				obj[3] = saa.getMoney();
//				list.add(obj);
//			}
//			String[] title = { "时间", "订单量", "实验次数", "项目收入" };
//			ExportExeclUtil.export("服务项目数据分析", "服务项目数据分析", title, list, request, response, startDate, endDate);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//	}
//
//	/**
//	 * 电销端订单列表导出
//	 *
//	 * @param request
//	 * @param response
//	 * @param orderDateList
//	 *            数据源
//	 * @throws Exception
//	 * @Author sz
//	 * @Time 2018年09月27日15:38:36
//	 */
//
//	public static void orderManagementListExport(HttpServletRequest request, HttpServletResponse response,
//			List<OrderDate> orderDateList) throws Exception {
//		List<Object[]> list = new ArrayList<Object[]>();
//		if (null != orderDateList && orderDateList.size() > 0) {
//			for (OrderDate orderDate : orderDateList) {
//				Object data[] = new Object[10];
//				data[0] = orderDate.getOrderNum() == null ? "" : orderDate.getOrderNum();
//				data[1] = orderDate.getOrderChannelName() == null ? "" : orderDate.getOrderChannelName();
//				data[2] = orderDate.getOrderIoName() == null ? "" : orderDate.getOrderIoName();
//				data[3] = orderDate.getOrderDsName() == null ? "" : orderDate.getOrderDsName();
//				data[4] = orderDate.getOrderSgName() == null ? "" : orderDate.getOrderSgName();
//				data[5] = orderDate.getOrderSpName() == null ? "" : orderDate.getOrderSpName();
//
//				data[6] = orderDate.getOrderTime() == null ? "" : DateUtil.format(orderDate.getOrderTime());
//				data[7] = orderDate.getOrderLogisticsNo() == null ? "" : orderDate.getOrderLogisticsNo();
//				data[8] = orderDate.getOrderAllMoney() == null ? "" : orderDate.getOrderAllMoney();
//				if (orderDate.getOrderState() == null)
//					data[9] = "";
//				else if (orderDate.getOrderState() == 1)
//					data[9] = "待支付";
//				else if (orderDate.getOrderState() == 2)
//					data[9] = "已支付";
//				else if (orderDate.getOrderState() == 3)
//					data[9] = "已撤销";
//				list.add(data);
//			}
//			String[] title = { "订单号", "下单渠道", "检测实验室", "下单收费项目", "所属团队", "销售人员", "下单时间", "物流单号", "订单金额", "订单状态" };
//			ExportExeclUtil.export("订单列表", "订单列表", title, list, request, response, null, null);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//
//	}
//
//	/**
//	 * 报告列表导出
//	 *
//	 * @param request
//	 * @param response
//	 * @param result
//	 * @param startDate
//	 * @param endDate
//	 * @throws Exception
//	 * @author czx
//	 * @时间 2018年9月29日 下午2:06:24
//	 */
//	public static void reportExport(HttpServletRequest request, HttpServletResponse response, List<Report> result,
//			Date startDate, Date endDate) throws Exception {
//		List<Object[]> list = new ArrayList<>();
//		if (result != null && result.size() > 0) {
//			for (Report r : result) {
//				Object[] obj = new Object[6];
//				obj[0] = r.getReportIoName();
//				obj[1] = r.getReportChannelName();
//				obj[2] = r.getReportName();
//				obj[3] = DateUtil.format(r.getReportTime());
//				obj[4] = r.getReportPatientNo();
//				obj[5] = r.getReportPatientName();
//				list.add(obj);
//			}
//			String[] title = { "检验所名称", "渠道名称", "报告名称", "报告时间" , "所属用户编号" , "所属用户姓名" };
//			ExportExeclUtil.export("报告单列表", "报告单列表", title, list, request, response, startDate, endDate);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//	}
//
//	/**
//	 * 条码号导出
//	 *
//	 * @param request
//	 * @param response
//	 * @param dataList
//	 * @param begin 范围begin
//	 * @param end 范围end
//	 * @param adminName 操作人
//	 * @author HeFeiyu
//	 * @date 2018年9月28日
//	 */
//	public static void exportBarCodeList(HttpServletRequest request, HttpServletResponse response,
//			List<BarCode> dataList, int begin, int end, String adminName) {
//		List<Object[]> list = new ArrayList<Object[]>();
//		if (null != dataList && dataList.size() > 0) {
//			for (BarCode barCode : dataList) {
//				Object data[] = new Object[1];
//				data[0] = barCode.getBarCodeNo();
//				list.add(data);
//			}
//			String[] title = {"条码号"};
//			BarCode first = dataList.get(0);
//			ExportExeclUtil.exportWithAdminName(
//					first.getBarCodeIoName() + "-" + first.getBarCodeChannelName() + "（" + begin + "-" + end + "）条码号",
//					first.getBarCodeIoName() + "-" + first.getBarCodeChannelName(), title, list, request, response, adminName);
//		}
//	}
//
//	/**
//	 * 销售人员列表导出
//	 * @param request
//	 * @param response
//	 * @param salePeopleList
//	 * @param startDate
//	 * @param endDate
//	 * @throws Exception
//	 * @author zhx
//	 * @date 2018年10月10日 上午8:55:25
//	 */
//	public static void salePeopleExport(HttpServletRequest request, HttpServletResponse response, List<SalePeopleOrder> salePeopleList,
//			Date startDate, Date endDate) throws Exception {
//		List<Object[]> list = new ArrayList<>();
//		if (salePeopleList != null && salePeopleList.size() > 0) {
//			for (SalePeopleOrder salePeople : salePeopleList) {
//				Object[] obj = new Object[6];
//				obj[0] = salePeople.getSpNo();
//				obj[1] = salePeople.getSpName();
//				obj[2] = salePeople.getSpPhone();
//				obj[3] = salePeople.getOrderSum();
//				obj[4] = salePeople.getOrderMoney();
//				obj[5] = salePeople.getSgName();
//				list.add(obj);
//			}
//			String[] title = { "销售人员编号", "负责人名称", "联系方式", "所售订单数" , "所售订单金额" , "所属团队" };
//			ExportExeclUtil.export("销售人员信息列表", "销售人员信息列表", title, list, request, response, startDate, endDate);
//		} else {
//			throw new Exception("列表信息为空！");
//		}
//	}
}
