package org.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.util.http.HttpUtil;

import net.sf.json.JSONObject;

import javax.xml.crypto.Data;


/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DateUtil {

	private static Date date_1000 = null;

	private static String url= "http://api.jisuapi.com/calendar/query?appkey=20e2ed88350e038a&date=";
	
	static {
		try {
			date_1000 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.parse("1000-01-01 00:00:00");
		} catch (ParseException e) {
		}
	}

	public static Date get1000Date() {
		return date_1000;
	}
	
	public static String format(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	/**
	 * 将Date 转换为 Sring类型     yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String format02(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}
	
	public static String format03(Date date){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}
	
	
	public static String formatDay(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String formatMonth2(Date date) {
		return new SimpleDateFormat("yyyy-MM").format(date);
	}
	
	public static String formatDay02(Date date) {
		return new SimpleDateFormat("yy-MM-dd").format(date);
	}
	
	public static String formatDay03(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}
	
	public static String formatDayHour(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH").format(date);
	}
	
	public static String formatDayChina(Date date) {
		return new SimpleDateFormat("yyyy年MM月dd日").format(date);
	}
	
	public static String formatDayChina2(Date date) {
		return new SimpleDateFormat("yyyy年MM月").format(date);
	}
	
	public static String formatHour(Date date) {
		return new SimpleDateFormat("HH").format(date);
	}
	
	public static String formatYear(Date date){
		return new SimpleDateFormat("YYYY").format(date);
	}
	
	public static String formatMonth(Date date){
		return new SimpleDateFormat("MM").format(date);
	}
	
	public static String formatMonthDay(Date date){
		return new SimpleDateFormat("MM-dd").format(date);
	}
	
	public static String formatYearMonthDay(Date date){
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	public static String format(String pattern, Date date) {
		if(null == date) {
			return null;
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 取得下一个更新统计缓存时间，即明日0点
	 * @return
	 */
	public static Date nextTaskTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * 取得当前月份
	 * @return
	 */
	public static Date getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	/**
	 * 获取 某个时间为起点  n个月后的 日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAfterMonth(Date date,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的n个月后的时间
        calendar.add(Calendar.MONTH,month);
		return calendar.getTime();
	}
	
	/**
	 * 获取 某个时间为起点  n天后的 日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAfterDay(Date date,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的n个月后的时间
        calendar.add(Calendar.DATE,day);
		return calendar.getTime();
	}
	
	/**
	 * 获取 某个时间为起点  n天前的 日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getDateBefore(Date d,int day){  
	    Calendar now =Calendar.getInstance();  
	    now.setTime(d);  
	    now.set(Calendar.DATE,now.get(Calendar.DATE)-day);  
	    return now.getTime();
	}  
	
	/**
	 * 获取 某个时间为起点  n个月后的  指定天 的 日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAfterMonth(Date date,int month,Integer day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的n个月后的时间
        calendar.add(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	/**
	 * 获取 某个时间为起点  n个月前的 日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getBeforeMonth(Date date,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的n个月后的时间
        calendar.add(Calendar.MONTH,-month);
		return calendar.getTime();
	}
	
	/**
	 * 取得当日0点
	 * @return
	 */
	public static Date getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
     * 获取当年的第一天
     * @param year
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
     
    /**
     * 获取当年的最后一天
     * @param year
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
     
    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
         
        return currYearLast;
    }
	
	public static Date addMinute(Date date, int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}
	
	public static int getDayWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public static Date threeDaysLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 3);
		return calendar.getTime();
	}
	
	public static int getHourOfDay() {
		return getHourOfDay(new Date());
	}
	
	public static int getHourOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getDayHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public static Date getDate(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}
	
	public static Date getPreDate(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, n);
		return calendar.getTime();
	}
	
	public static Date getNextDayDate(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static Date twoHoursLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, 2);
		return calendar.getTime();
	}
	
	public static Date oneHoursLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		return calendar.getTime();
	}
	
	public static Date addHours(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}
	
	public static Date getMonthOneDate(int next) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.MONTH, next);
		return calendar.getTime();
	}
	
	public static Date get0Dian(Date date, int next) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, next);
		return calendar.getTime();
	}
	
//	public static void main(String[] args) {
//		String a = formatDD(new Date());
//		System.out.println(a);
//	}
	
	/**
	 * 传入一个日期和天数，计算该日期加num天后的日期
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date plusDate(Date date, Integer num){
		Date calculDate = new Date(date.getTime() + num*1000*60*60*24);
		return calculDate;
	}
	
	/**
	 * 传入一个日期和天数，计算该日期加num天后的日期（这个方式避免了数组越界，采用这个方式）
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date plusDateNum(Date date, Integer num){
		int oneDay = 1000*60*60*24;
		BigDecimal day = new BigDecimal(oneDay).multiply(new BigDecimal(num));
		Date calculDate = new Date(date.getTime() + day.longValue());
		return calculDate;
	}
	
	/**
	 * 传入一个日期和天数，计算该日期减num天后的日期
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date minusDate(Date date, Integer num){
		Date calculDate = new Date(date.getTime() - num*1000*60*60*24);
		return calculDate;
	}
	
	/**
	 * 传入一个日期和天数，计算该日期减num天后的日期
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date minusDateNum(Date date, Integer num){
		int oneDay = 1000*60*60*24;
		BigDecimal day = new BigDecimal(oneDay).multiply(new BigDecimal(num));
		Date calculDate = new Date(date.getTime() - day.longValue());
		return calculDate;
	}
	
	/**
	 * 将String类型的日期 转换为 Date类型  yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	/**
	 * 将String类型的日期 转换为 Date类型  yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringDate02(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	/**
	 * 将String类型的日期 转换为 Date类型  yyyy-MM-dd 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringDate03(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	
	/**
	 * 日期转换成月
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringMonth(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	
	/**
	 * 将String类型的日期 转换为 Date类型  yyyyMMdd 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringDate04(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	
	/**
	 * 获取当前时间  Date类型  yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static Date getNowTime() throws ParseException{
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return changStringDate(time);
	}
	
	/**
	 * 获取当前年份 Date类型  yyyy
	 * @return
	 * @throws ParseException
	 */
	public static Date getNowYear() throws ParseException{
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy");
		String time=format.format(date);
		return changStringDate(time);
	}

	public static Date getNowYearOnlyYear() throws ParseException{
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy");
		String time=format.format(date);
		return new SimpleDateFormat("yyyy").parse(time);
	}
	
	/**
	 * 将Date类型 转换为 yyyy-MM-dd 格式的Date
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getDateFormat(Date date) throws ParseException {  
	    Date currentTime = date;  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    return changStringDate03(dateString);  
	}  
	/**
	 * 将Date类型 转换为 yyyy-MM 格式的Date
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getMonthFormat(Date date) throws ParseException {  
	    Date currentTime = date;  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");  
	    String dateString = formatter.format(currentTime);  
	    return changStringDate03(dateString);  
	}  
	
	/**
	 * 获取当前时间  Date类型  yyyyMMddHHmmss
	 * @return
	 * @throws ParseException
	 */
	public static Date getNowTime2() throws ParseException{
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return changStringDate(time);
	}
	
	/**
	 * 获取传入时间的当天开始时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getTodaystart(Date date)throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	     
	    Date start = calendar.getTime();
		return start;
	}
	
	/**
	 * 获取传入时间的当天结束时间（修改之后）
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getTodayfinish(Date date)throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	     
	    Date finish = calendar.getTime();
		return finish;
	}
	
	/**
	 * 获取传入时间的当天结束时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getTodayend(Date date)throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	     
	    Date end = calendar.getTime();
		return end;
	}
	
	
	/**
	 * 获取传入时间的当月开始时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getMonthstart(Date date)throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	     
	    Date start = calendar.getTime();
		return start;
	}
	
	
	
	/**
	 * 获取传入时间的当月结束时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getMonthend(Date date)throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    calendar.set(Calendar.HOUR_OF_DAY,23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	     
	     
	    Date end = calendar.getTime();
		return end;
	}
	
	/**  
	 * 计算出两个日期之间相差的天数  
	 * 建议date1 大于 date2 这样计算的值为正数  
	 * @param date1 日期1  
	 * @param date2 日期2  
	 * @return date1 - date2  
	 */  
	public static int dateInterval(long date1, long date2) { 
	    if(date2 > date1){ 
	        date2 = date2 + date1; 
	        date1 = date2 - date1; 
	        date2 = date2 - date1; 
	    } 
	 
	     // Canlendar 该类是一个抽象类   
	     // 提供了丰富的日历字段  
	     // 本程序中使用到了  
	     // Calendar.YEAR    日期中的年份  
	     // Calendar.DAY_OF_YEAR     当前年中的天数  
	     // getActualMaximum(Calendar.DAY_OF_YEAR) 返回今年是 365 天还是366天  
	    Calendar calendar1 = Calendar.getInstance(); // 获得一个日历   
	    calendar1.setTimeInMillis(date1); // 用给定的 long 值设置此 Calendar 的当前时间值。   
	        
	    Calendar calendar2 = Calendar.getInstance(); 
	    calendar2.setTimeInMillis(date2); 
	    // 先判断是否同年   
	    int y1 = calendar1.get(Calendar.YEAR); 
	    int y2 = calendar2.get(Calendar.YEAR); 
	        
	    int d1 = calendar1.get(Calendar.DAY_OF_YEAR); 
	    int d2 = calendar2.get(Calendar.DAY_OF_YEAR); 
	    int maxDays = 0; 
	    int day = 0; 
	    if(y1 - y2 > 0){ 
	        day = numerical(maxDays, d1, d2, y1, y2, calendar2); 
	    }else{ 
	        day = d1 - d2; 
	    } 
	    return day; 
	} 
	
	/**  
	 * 日期间隔计算  
	 * 计算公式(示例):  
	 *      20121201- 20121212 
	 *      取出20121201这一年过了多少天 d1 = 天数  取出20121212这一年过了多少天 d2 = 天数 
	 *      如果2012年这一年有366天就要让间隔的天数+1，因为2月份有29日。  
	 * @param maxDays   用于记录一年中有365天还是366天  
	 * @param d1    表示在这年中过了多少天  
	 * @param d2    表示在这年中过了多少天  
	 * @param y1    当前为2012年  
	 * @param y2    当前为2012年  
	 * @param calendar  根据日历对象来获取一年中有多少天  
	 * @return  计算后日期间隔的天数  
	 */  
	public static int numerical(int maxDays, int d1, int d2, int y1, int y2, Calendar calendar){ 
	    int day = d1 - d2; 
	    int betweenYears = y1 - y2; 
	    List<Integer> d366 = new ArrayList<Integer>(); 
	        
	    if(calendar.getActualMaximum(Calendar.DAY_OF_YEAR) == 366){ 
	        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)); 
	        day += 1; 
	    } 
	        
	    for (int i = 0; i < betweenYears; i++) { 
	        // 当年 + 1 设置下一年中有多少天   
	        calendar.set(Calendar.YEAR, (calendar.get(Calendar.YEAR)) + 1); 
	        maxDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR); 
	        // 第一个 366 天不用 + 1 将所有366记录，先不进行加入然后再少加一个  
	        if(maxDays != 366){ 
	            day += maxDays; 
	        }else{ 
	            d366.add(maxDays); 
	        } 
	        // 如果最后一个 maxDays 等于366 day - 1   
	        if(i == betweenYears-1 && betweenYears > 1 && maxDays == 366){ 
	            day -= 1; 
	        } 
	    } 
	        
	    for(int i = 0; i < d366.size(); i++){ 
	        // 一个或一个以上的366天   
	        if(d366.size() >= 1){ 
	            day += d366.get(i); 
	        }  
	    }   
	    return day; 
	} 
	
	/** 
     * 计算两个日期之间相差的天数 
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException 
     */  
    public static int daysBetween(Date smdate,Date bdate) throws ParseException{  
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     smdate=sdf.parse(sdf.format(smdate));
     bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();  
        cal.setTime(smdate);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(bdate);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);
          
       return Integer.parseInt(String.valueOf(between_days));         
    }
    
    /**
	  * 计算两个时间差 ，不足1小时按1小时
	  */
	 public static Long hourDiff(Date startTime,Date endTime){
		 
		 //毫秒ms
        Long diff =endTime.getTime() - startTime.getTime();
        Long hourCount = diff / (60 * 1000*60) ;
		 
        //秒
        Long diffSeconds = diff / 1000 % 60;
        //分
        Long diffMinutes = diff / (1000*60) % 60;
        //不足一分钟按一分钟算
        if(0!=diffSeconds||0!=diffMinutes){
       	 hourCount++;
        }
		 return hourCount;
	 }
    
    /** 
     * 计算两个日期之间相差的天数（基于算法重新写，闰年按照365天计算） 
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException 
     */  
    public static int daysBetween365(Date smdate,Date bdate) throws ParseException{  
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     smdate=sdf.parse(sdf.format(smdate));
     bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();  
        cal.setTime(smdate);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(bdate);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);
        int days = Integer.parseInt(String.valueOf(between_days));//原始正常的数值
        //减去中间所有的闰年天数
        String sYear = format03(smdate).substring(0, 4);
        String sMonth = format03(smdate).substring(4, 6);
        String sDay = format03(smdate).substring(6, 8);
        String bYear = format03(bdate).substring(0, 4);
        String bMonth = format03(bdate).substring(4, 6);
        String bDay = format03(bdate).substring(6, 8);
        
        int subS = 0;
        int subM = 0;
        int subL = 0;
        //开始那年
        if (Integer.valueOf(sYear) %4 == 0 && Integer.valueOf(sMonth) == 1 ) {
			subS = 1;
		}else if (Integer.valueOf(sYear) %4 == 0 && Integer.valueOf(sMonth) == 2 && Integer.valueOf(sDay) < 29) {
			subS = 1;
		}else{
			
		}
        int middleYear = Integer.valueOf(bYear) - Integer.valueOf(sYear) - 1;
        if (middleYear > 0) {
        	//中间
        	 for (int i = 1; i < middleYear + 1; i++) {
             	int s = Integer.valueOf(sYear) + i;
     			if (s%4 == 0) {
     				subM = subM + 1;
     			}
     		}
        	//结束那年
        	if (Integer.valueOf(bYear) %4 == 0 && Integer.valueOf(bMonth) == 2 && Integer.valueOf(bDay) > 28) {
        		subL = 1;
			}else if (Integer.valueOf(bYear) %4 == 0 && Integer.valueOf(bMonth) > 2) {
				subL = 1;
			}
		}
       return days - subS - subM - subL;         
    }
   
    
    /**
     * 判断日期是否是休息
     * @param date
     * @return
     * @throws Exception
     */
    public static boolean judgeHoliday(Date date)throws Exception{
    	String datestring = formatDay(date);
    	String string = HttpUtil.requestForString(url+datestring, null, null, false, false);
    	JSONObject jsonObject = JSONObject.fromObject(string);
    	JSONObject result = (JSONObject)jsonObject.get("result");
    	String workholiday = (String)result.get("workholiday");
    	String week = (String)result.get("week");
    	if(null!=workholiday && workholiday.equals("0")){
    		return true;
    	}else if(null!=workholiday && workholiday.equals("1")){
    		return false;
    	}else if(week.equals("六")||week.equals("日")){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    /**
     * 获取传入日期的情况
     * @param date
     * @return
     * @throws Exception
     */
    public static JSONObject getTime(Date date)throws Exception{
    	String datestring = formatDay(date);
    	String string = HttpUtil.requestForString(url+datestring, null, null, false, false);
    	JSONObject jsonObject = JSONObject.fromObject(string);
    	JSONObject result = (JSONObject)jsonObject.get("result");
    	return result;
    }
    /**
     * 比较两个日期的大小
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public  static Integer compare(Date date1,Date date2)throws Exception{
    	if(date1.getTime()>date2.getTime()){
    		return 1;
    	}else if(date1.getTime()<date2.getTime()){
    		return -1;
    	}
    	return 0;
    }
    
    /**
     * 获取当前年份总共有多少天
     * @return
     * @throws ParseException
     */
    public static int getNowYearDays() throws Exception{
    	int nowYearDays = 0;
    	Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy");
		String time=format.format(date);
		int nowYear = Integer.valueOf(time);
		if (nowYear % 4 == 0) {//年份可以整除4
			nowYearDays = 366;
		}else{//年份不能整除4
			nowYearDays = 365;
		}
		return nowYearDays;
    }
    
    /**
     * 获取当前月份总共有多少天
     * @param year
     * @param month
     * @return
     */
    public static int getDayNumByYearandMonth(String year, String month) throws Exception{
		int num = 0;
		if ("1".equals(month) || "3".equals(month) || "5".equals(month) || "7".equals(month)
				|| "8".equals(month) || "10".equals(month) || "12".equals(month) 
				|| "01".equals(month) || "03".equals(month) || "05".equals(month)
				|| "07".equals(month) || "08".equals(month)) {
			num = 31;
		}else if("4".equals(month) || "6".equals(month) || "9".equals(month) || "11".equals(month)
				|| "04".equals(month) || "06".equals(month) || "09".equals(month)){
			num = 30;
		}else if(("2".equals(month) || "02".equals(month)) && Integer.valueOf(year)%4 == 0) {//闰年2月
			num = 29;
		}else if(("2".equals(month) || "02".equals(month)) && Integer.valueOf(year)%4 != 0) {//平年2月
			num = 28;
		}else{
			
		}
		return num;
	}
    
    /**
     * 返回指定年季的   季的  指定某天  23时
     * @param year
     * @param quarter
     * @return
     */
     public static Date getLastDayOfQuarter(Integer year, Integer quarter,Integer day) {
         Calendar calendar = Calendar.getInstance();
         Integer month = new Integer(0);
         if (quarter == 1) {
             month = 3 - 1;
         } else if (quarter == 2) {
             month = 6 - 1;
         } else if (quarter == 3) {
             month = 9 - 1;
         } else if (quarter == 4) {
             month = 12 - 1;
         } else {
             month = calendar.get(Calendar.MONTH);
         }
         
         Calendar calendar2 = Calendar.getInstance();
         calendar2.set(Calendar.DAY_OF_MONTH, 1);
         calendar2.set(Calendar.HOUR_OF_DAY, 23);
         calendar2.set(Calendar.MINUTE, 0);
         calendar2.set(Calendar.SECOND, 0);
         calendar2.set(Calendar.MILLISECOND, 0);
         calendar2.set(year, month, day);
         if (year == null) {
             year = calendar.get(Calendar.YEAR);
         }
         if (month == null) {
             month = calendar.get(Calendar.MONTH);
         }
         calendar2.set(year, month, day);
      //   calendar2.roll(Calendar.DATE, -1);
     	return calendar2.getTime();
     }
     /**
      * 获取当前年份
      * @return
      */
     public static  Integer getYear(){
    	 Calendar calendar = Calendar.getInstance();
    	 calendar.setTimeInMillis(System.currentTimeMillis());
    	 int currenYear = calendar.get(Calendar.YEAR);
    	 return currenYear;
     }
     
     /**
      * 获取当前季度
      * @return
      */
     public static Integer getQuarter(){
    	 Calendar calendar = Calendar.getInstance();
    	 calendar.setTimeInMillis(System.currentTimeMillis());
    	 int currenMonth = calendar.get(Calendar.MONTH);
    	 int currentQuarter = 1;
    	 if(4==currenMonth||5==currenMonth||6==currenMonth){
    		 currentQuarter = 2;
    	 }else if(7==currenMonth||8==currenMonth||9==currenMonth){
    		 currentQuarter = 3;
    	 }else if(10==currenMonth||11==currenMonth||12==currenMonth){
    		 currentQuarter = 4;
    	 }
    	 return currentQuarter;
     }
     /**
      * 获取当前月份
      * @return
      */
     public static Integer getMonth(){
    	 Calendar calendar = Calendar.getInstance();
    	 calendar.setTimeInMillis(System.currentTimeMillis());
    	 int currenMonth = calendar.get(Calendar.MONTH);
    	 return currenMonth;
     }
     
  	/**
  	 *  返回指定年月的   月的   指定某天  23时
  	 * @param year
  	 * @param month
  	 * @return
  	 */
  	 public static Date getLastDayOfMonth(Integer year, Integer month,Integer day) {
  		 Calendar calendar = Calendar.getInstance();
  	     calendar.set(Calendar.DAY_OF_MONTH, 1);
  			calendar.set(Calendar.HOUR_OF_DAY, 23);
  			calendar.set(Calendar.MINUTE, 0);
  			calendar.set(Calendar.SECOND, 0);
  			calendar.set(Calendar.MILLISECOND, 0);
  	        if (year == null) {
  	            year = calendar.get(Calendar.YEAR);
  	        }
  	        if (month == null) {
  	            month = calendar.get(Calendar.MONTH);
  	        }
  	        calendar.set(year, month-1, day);
  	     //   calendar.roll(Calendar.DATE, -1);
  		 return calendar.getTime();
  	 }
 	 
 	 /**
 	  * 获取当前时间的前n个小时
 	  * @return
 	  */
 	 public static Date getHourBefore(Integer hour){
 		Calendar calendar = Calendar.getInstance();
 		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
 		 return calendar.getTime();
 	 }
 	 
 	 /**
 	  * 判断当前时间是否为早8点
 	  * @return
 	  */
 	 public static Boolean ifEight(){
 		Calendar calendar = Calendar.getInstance();
 		int hour = calendar.get(Calendar.HOUR_OF_DAY);
 		if(8==hour){
 			return true;
 		}
 		return false;
 	 }
 	 
 	 public static Date stringToDate(String st) throws ParseException{
 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
 		Date date=sdf.parse(st); 
 		 return date;
 	 }
 	 
 	 /**
 	  *当前时间 减去 n秒 后的时间
 	  * @param second
 	  * @return
 	  */
 	 public static Date dateMinusSecond(Integer second){
	    Calendar calendar = Calendar.getInstance ();
        calendar.add (Calendar.SECOND, -second);
        return calendar.getTime();
 	 }
 	 
 	 /**
 	  * 判断传入时间是否是当天
 	  * true 是当天，false 不是当天
 	  * @param date
 	  * @return
 	  */
 	 public static boolean isToday(Date date){
 		if (formatYearMonthDay(new Date()).equals(formatYearMonthDay(date))) {
			return true;
		}else{
			return false;
		}
 	 }	 
 	 
 	 /**
 	  * 今天第一次登录时，判断上次登录是不是昨天（检查是否有连续登录）
 	  * true 是昨天，有连续登录 ，false 不是昨天，没有联系登录
 	  * @param date
 	  * @return
 	  */
 	 public static boolean isYesterday(Date date){
 		 if (Integer.valueOf(formatYearMonthDay(new Date())) - Integer.valueOf(formatYearMonthDay(date)) == 1) {
			return true;
		}else{
			return false;
		}
 	 }
 	 
 	 /**
 	  * 获取当前周的时间列表
 	  * @param date
 	  * @return
 	  */
 	 public static List<Date> getWeekDay(Date date) {
 		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
         Calendar cal = Calendar.getInstance();  
         List<Date> dateList = new ArrayList<Date>();
         Date time = new Date();
         try {
			time = getDateFormat(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
         cal.setTime(time);           
         //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
         if(1 == dayWeek) {  
           cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值   
        System.out.println("所在周星期一的日期："+sdf.format(cal.getTime()));
        dateList.add(cal.getTime());
        for(int i=0;i<7;i++) {
        	cal.add(Calendar.DATE,1);
        	dateList.add(cal.getTime());
        	System.out.println(sdf.format(cal.getTime()));
        }
        System.out.println(dateList.size());
		return dateList; 		 
 	 }

	/**
	 * 计算两个时间的月份差 直接进行月份的比较 不会比较天数
	 * @param dateBefore
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static int timeMonth(Date dateBefore ,Date date) throws Exception{
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(dateBefore);
		aft.setTime(date);
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		return month + result;
	}

	/**
	 * 获取指定年月日的时间  不区分平闰年
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date setTime(int year,int month,int day){
		Calendar calendar=Calendar.getInstance();
		  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
		if(day < 29 && month >0 && month <= 12){
			calendar.set(year, month - 1, day);
		}else if(day < 32){
			if( month == 2){
				calendar.set(year, month - 1, 28);
			}else if( day < 31){
				calendar.set(year, month - 1, day);
			}else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
				calendar.set(year, month - 1, day);
			}else{
				calendar.set(year, month - 1, 30);
			}
		}else{
			return null;
		}
		return calendar.getTime();
	}
	/**
	 * 将String类型的日期 转换为 Date类型  yyyy-MM  合同专用
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date changStringDate10(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Date creatTime = sdf.parse(date);
		return creatTime;
	}
	
	/**
	 * 获取传入时间是星期几
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekDayNum(Date date) throws ParseException{
        SimpleDateFormat sdw = new SimpleDateFormat("E");  
        return sdw.format(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}
	
	/**
	 * 根据星期几获取数字
	 * @param weekDayNum
	 * @return
	 * @throws ParseException
	 */
	public static Integer getDayNum(String weekDayNum) throws ParseException{
		Integer num = 0;
		if (weekDayNum != null && "星期一".equals(weekDayNum)) {
			num = 1;
		}else if (weekDayNum != null && "星期二".equals(weekDayNum)) {
			num = 2;
		}else if (weekDayNum != null && "星期三".equals(weekDayNum)) {
			num = 3;
		}else if (weekDayNum != null && "星期四".equals(weekDayNum)) {
			num = 4;
		}else if (weekDayNum != null && "星期五".equals(weekDayNum)) {
			num = 5;
		}else if (weekDayNum != null && "星期六".equals(weekDayNum)) {
			num = 6;
		}else if (weekDayNum != null && "星期日".equals(weekDayNum)) {
			num = 7;
		}
		return num;
	}
	
	/**
	 * 获得天的开始和结束时间 例 2018-10-5 00:00:00 - 2018-10-6 00:00:00
	 * @param time
	 * @return
	 */
	public static Date[] dayBeginAndEndTime (Date time) {
		Date[] dates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.clear();
		calendar.set(year, month, day);
		dates[0] = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		dates[1] = calendar.getTime();
		return dates;
	}
	
	/**
	 * 月的结束和开始时间
	 * @param time
	 * @return
	 */
	public static Date[] getMonthBeginAndEndTime(Date time) {
		Date[] result = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		calendar.clear();
		calendar.set(year, month - 1, 1);
		result[0] = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		result[1] = calendar.getTime();
		System.out.println(result[0] + "," + result[1]);
		return result;
	}
	
	/**
	 * 获得年的开始和结束时间
	 * 
	 * @param time
	 * @return
	 * @author HeFeiyu
	 * @date 2018年9月20日
	 */
	public static Date[] getYearBeginAndEndTime(Date time) {
		Date[] result = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		result[0] = calendar.getTime();
		year++;
		calendar.set(Calendar.YEAR, year);
		result[1] = calendar.getTime();
		return result;
	}
	
	/**
	 * 星期的开始和结束时间
	 * 
	 * @param time
	 * @return
	 * @author HeFeiyu
	 * @date 2018年9月26日
	 */
	public static Date[] getWeekBeginAndEndTime(Date time) {
		Date[] result = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		int day = calendar.get(Calendar.DATE);
		calendar.clear();
		calendar.set(year, month - 1, day);
		calendar.add(Calendar.DAY_OF_MONTH, -(weekDay-1));
		result[0] = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		result[1] = calendar.getTime();
		//System.out.println(result[0] + "," + result[1]);
		return result;
	}


	/**
	 * 获得月份的天数
	 *
	 * @param time
	 * @return
	 * @author HeFeiyu
	 * @date 2018年9月20日
	 */
	public static int getDaysOfMonth(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 获得当前日期的处在月的每一个date
	 * @param date date
	 * @author quantangkun
	 * 2018年9月20日
	 */
	public static List<Date> getAllTheDateOftheMonth(Date date) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		int month = cal.get(Calendar.MONTH);
		while(cal.get(Calendar.MONTH) == month){
			list.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}
	
	/**
	 * 获得指定季度的开始和结束时间
	 * 
	 * @param time （例：2018,3 表示2018年第3季度）
	 * @return
	 * @author HeFeiyu
	 * @date 2018年9月26日
	 */
	public static Date[] getQuarterBeginTimeAndEndTime(String time) {
		if (time == null || time.length() <= 0 || time.split(",").length < 2) {
			return null;
		}
		Date[] result = new Date[2];
		String[] splits = time.split(",");
		int year = Integer.parseInt(splits[0]);
		int quarter = Integer.parseInt(splits[1]);
		int beginMonth = (quarter - 1) * 3 + 1; 
		int endMonth = beginMonth + 2;
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, beginMonth - 1, 1);
		result[0] = calendar.getTime();
		int nextYear = year;
		if (endMonth == 12) {
			endMonth = 1;
			nextYear++;
		} else 
			endMonth++;
		calendar.set(nextYear, endMonth - 1, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		result[1] = calendar.getTime();
		return result;
	}


	/**
	 * 得到上个月最后一天
	 * @author quantangkun
	 * @param date 任意日期
	 * @return java.util.Date
	 * 2018/9/26 15:27
	 */
	public static Date getLastMonthLastDay(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int m = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH,m);
		calendar.set(Calendar.DATE,0);

		return calendar.getTime();
	}
	/**
	 * 得到本月第一天
	 * @author quantangkun
	 * @param date 任意日期
	 * @return java.util.Date
	 * 2018/9/26 15:27
	 */
	public static Date getMonthFristDay(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,1);
		return calendar.getTime();
	}

	/**
	 * 得到去年最后一天
	 * @author quantangkun
	 * @param date 任意日期
	 * @return java.util.Date
	 * 2018/9/26 15:27
	 */
	public static Date getLastYearLastDay(Date date) throws ParseException {

		return getLastYearDay(date,1,12);
	}

	/**
	 * 得到n年前m月的最后一天
	 * @author quantangkun
	 * @param date 任意日期
	 * @return java.util.Date
	 * 2018/9/26 15:27
	 */
	public static Date getLastYearDay(Date date,int n,int Month) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,0-n);
		calendar.set(Calendar.MONTH,Month);
		calendar.set(Calendar.DATE,0);
		return calendar.getTime();
	}
	public static void main(String[] args) throws ParseException {
		Date date =new SimpleDateFormat("yyyy-MM-dd").parse("2018-3-12");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	}
}
