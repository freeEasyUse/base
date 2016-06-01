package org.base.test.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DTest {
	public static void main(String[] args) {
		BigDecimal d = new BigDecimal(4600.00);
		BigDecimal c = new BigDecimal(17.0000);
		Elem e = new Elem();
		e.setVAMOUNT(d.divide(c.multiply(BigDecimal.valueOf(0.01)).add(BigDecimal.valueOf(1)),
                4,
                RoundingMode.HALF_UP).toString());
		System.out.println(e.getVAMOUNT());
	}
}
