package org.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * bigdecimal 转换
 * @author arron
 *
 */
public class NumberChange {
	
	public static String changeNum(BigDecimal bigDecimal) throws Exception{
		if(bigDecimal.compareTo(new BigDecimal(10000))==-1){
			bigDecimal = bigDecimal.divide(new BigDecimal(1),0,BigDecimal.ROUND_HALF_EVEN);
			return bigDecimal+"";
		}else if(bigDecimal.compareTo(new BigDecimal(100000000))==-1){
			//取余
			BigDecimal	remainder = bigDecimal.remainder(new BigDecimal(10000));
			//如果余数为0
			if(new BigDecimal("0.000000").equals(remainder)){
				bigDecimal = bigDecimal.divide(new BigDecimal(10000),0,BigDecimal.ROUND_HALF_EVEN);
				return bigDecimal+"万";
			}
			bigDecimal = bigDecimal.divide(new BigDecimal(10000),1,BigDecimal.ROUND_HALF_EVEN);
			return bigDecimal+"万";
		}else{
			//取余
			BigDecimal	remainder = bigDecimal.remainder(new BigDecimal(100000000));
			//如果余数为0
			if(new BigDecimal("0.000000").equals(remainder)){
				bigDecimal = bigDecimal.divide(new BigDecimal(100000000),0,BigDecimal.ROUND_HALF_EVEN);
				return bigDecimal+"亿";
			}
			bigDecimal = bigDecimal.divide(new BigDecimal(100000000),1,BigDecimal.ROUND_HALF_EVEN);
			return bigDecimal+"亿";
		}
	}
	public static String formatTosepara(String str) {
		BigDecimal bd = new BigDecimal(str);
		bd = bd.setScale(2,BigDecimal.ROUND_UP);
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		return(nf.format(bd.doubleValue()));
	}
	
	public static void main(String[] args) {
		BigDecimal b = new BigDecimal("65.66666666");
		System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP));
//		String num = "0.55555";
//		BigDecimal bd = new BigDecimal(num);
//		bd = bd.setScale(2,BigDecimal.ROUND_UP);
//		NumberFormat nf = NumberFormat.getInstance(Locale.US);
//		System.out.println(nf.format(bd.doubleValue()));

	}
}
