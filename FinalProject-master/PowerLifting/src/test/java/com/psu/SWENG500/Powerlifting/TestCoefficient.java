package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.FemaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.MaleCoefficient;

/**
 * @author Jason JUnit to test the use of the Wilks coefficient equation, data
 *         outputs taken from http://www.usapowerlifting.com/lifters-corner
 */
public class TestCoefficient extends TestCase {
	MaleCoefficient mCo = new MaleCoefficient();
	FemaleCoefficient fCo = new FemaleCoefficient();
	int PRECISION = 10000;

	public void testMaleCoefficient() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setWeight(new Double(150));

		Double coefficient = mCo.getCoefficient(person);
		coefficient = Math.floor(coefficient * PRECISION + .5) / PRECISION;
		assertEquals(.7661, coefficient);
	}

	public void testFemaleCoefficient() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setWeight(new Double(150));

		Double coefficient = fCo.getCoefficient(person);
		coefficient = Math.floor(coefficient * PRECISION + .5) / PRECISION;
		assertEquals(1.0148, coefficient);
	}
}
