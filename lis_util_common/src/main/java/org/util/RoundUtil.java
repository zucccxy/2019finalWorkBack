package org.util;

import java.math.BigDecimal;

public class RoundUtil {
	
	public static BigDecimal round(BigDecimal money)throws Exception{
		return money.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
