package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 * 
 *         Coefficient numbers for Males, taken from
 *         http://www.usapowerlifting.com/lifters-corner
 *
 */
public class MaleCoefficient extends Coefficient {

	public MaleCoefficient() {
		variables.add(new Double(-216.0475144));
		variables.add(new Double(16.2606339));
		variables.add(new Double(-0.002388645));
		variables.add(new Double(-0.00113732));
		variables.add(new Double(0.00000701863));
		variables.add(new Double(-0.00000001291));
	}
}
