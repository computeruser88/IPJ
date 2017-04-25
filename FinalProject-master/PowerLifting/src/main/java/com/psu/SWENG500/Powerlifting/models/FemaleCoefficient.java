package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 * 
 *         Coefficient numbers for female, taken from
 *         http://www.usapowerlifting.com/lifters-corner
 *
 */
public class FemaleCoefficient extends Coefficient {

	public FemaleCoefficient() {
		variables.add(new Double(594.31747775582));
		variables.add(new Double(-27.23842536447));
		variables.add(new Double(0.82112226871));
		variables.add(new Double(-0.00930733913));
		variables.add(new Double(0.00004731582));
		variables.add(new Double(-0.00000009054));
	}
}
