package com.psu.SWENG500.Powerlifting.models.converters;

import java.math.BigDecimal;

/**
 * Utility to round numbers to a certain decimal point, found on codejava.net
 *
 */
public class DecimalUtils {
	public static Double round(double value, int numDigitsAfterDecimalPoint) {
		BigDecimal bigDecimal = new BigDecimal(value);
		bigDecimal = bigDecimal.setScale(numDigitsAfterDecimalPoint, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
	}
}
