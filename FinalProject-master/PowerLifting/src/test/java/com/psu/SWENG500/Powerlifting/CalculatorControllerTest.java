package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.controller.CalculatorController;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.converters.DecimalUtils;

/**
 * @author Jason
 * 
 *         JUnit to test the Calculator class that calculates the functions for
 *         Body Mass Index and Wilks Scores
 */
public class CalculatorControllerTest extends TestCase {
	private CalculatorController calc = new CalculatorController();

	public CalculatorControllerTest(String testName) {
		super(testName);
	}

	public void testCalcWilksScore() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setWeight(new Double(150));

		//ImperialMeasurement lifting = new ImperialMeasurement();
		//lifting.setWeight(new Double(400));
		double total = calc.calculateWilks(person, 400, true);

		total = Math.round(total);

		assertNotNull(total);

		assertEquals(139.0, total);
	}

	public void testBodyMassIndex() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setHeight(new Double(72));
		person.setWeight(new Double(180));
		Double bmi = calc.calculateBodyMassIndex(person);
		bmi = DecimalUtils.round(bmi, 1);
		assertNotNull(bmi);
		assertEquals(24.4, bmi);

		person = new ImperialMeasurement();
		person.setHeight(new Double(72));
		bmi = calc.calculateBodyMassIndex(person);
		assertNull(bmi);
	}
	
	public void testBodyFatPercentage(){
		//MALE
		ImperialMeasurement person = new ImperialMeasurement(72,190, 30.5);
		Double leanBodyMass = calc.calculateBodyFatPercentage(person, true);
		leanBodyMass = DecimalUtils.round(leanBodyMass, 2);
		assertNotNull(leanBodyMass);
		assertEquals(8.72, leanBodyMass);
		
		//FEMALE
		person = new ImperialMeasurement(72,125,24,6,38,9.5);
		leanBodyMass = calc.calculateBodyFatPercentage(person, false);
		leanBodyMass = DecimalUtils.round(leanBodyMass, 2);
		assertNotNull(leanBodyMass);
		assertEquals(25.37, leanBodyMass);
	}
}
