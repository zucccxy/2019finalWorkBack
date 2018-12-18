package org.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生成【min,max】的随机数
 * @author Administrator
 *
 */
public class RandomUtil {
    
    private static String[] num = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	public static Integer Random(Integer min, Integer max){
		Random random = new Random();
        Integer ran = random.nextInt(max - min + 1) + min;
        return ran;
	}
	
	/**
     * 生成n位随机字符串
     * 
     * @return
     */
    public static String getStringRandom(int n) {
        Random random = new Random();
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<n;i++) {
        	int index = random.nextInt(str.length());
        	newStr.append(str.charAt(index));
        }
        return newStr.toString();
    }
    
    /**
     * 生成n位随机数
     * 
     * @return
     */
    public static String getRandomNum(int n) {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < n; i++) {
            code = code + num[random.nextInt(10)];
        }
        return code;
    }
}
