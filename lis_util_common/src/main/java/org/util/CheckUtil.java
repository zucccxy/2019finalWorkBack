package org.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//后台验证
public class CheckUtil {
	//验证邮箱
   public static boolean checkEmail(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*\\@([\\.\\w-]+)+$"); 
	   Matcher matcher = pattern.matcher(str); 
	   return matcher.matches();
   }
   //验证手机号码
   public static boolean checkTel(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches(); 
   }
   //验证密码长度6~15
   public static boolean checkPassword(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[0-9_a-zA-Z]{6,15}$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }
 //验证密码是否相同
   public static boolean checkPasswordIsEqual(String str1,String str2) throws Exception{
	   Pattern pattern = Pattern.compile(str1);
	   Matcher matcher = pattern.matcher(str2);
       return matcher.matches();
   }
 //验证非空，不适用textArea
   public static boolean checkIsNull(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[\\S]+$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }
   /**
   * 验证输入身份证号
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsIDcard(String str) {
	   Pattern pattern = Pattern.compile("(^\\d{18}$)|(^\\d{15}$)");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证数字输入
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsNumber(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[0-9]*$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证非零的正整数
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsIntNumber(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证大写字母
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsUpChar(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[A-Z]+$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证小写字母
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsLowChar(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[a-z]+$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证验证输入字母
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsLetter(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[A-Za-z]+$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证验证输入汉字
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsChinese(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5],{0,}$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

   /**
   * 验证验证输入字符串
   * 
   * @param 待验证的字符串
   * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
   */
   public static boolean IsLength(String str) throws Exception{
	   Pattern pattern = Pattern.compile("^.{8,}$");
	   Matcher matcher = pattern.matcher(str);
       return matcher.matches();
   }

}
