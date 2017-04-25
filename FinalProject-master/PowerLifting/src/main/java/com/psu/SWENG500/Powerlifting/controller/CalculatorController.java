package com.psu.SWENG500.Powerlifting.controller;

import com.psu.SWENG500.Powerlifting.interfaces.CalculatorView;
import com.psu.SWENG500.Powerlifting.models.FemaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MeasurementType;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.converters.MeasurementConverter;

/**
 * @author Jason
 *
 *         Controller class for the Calculator that makes the calculation for
 *         Body Mass Index and Wilks Score
 */
public class CalculatorController extends CalculatorView {

	MaleCoefficient mCo = new MaleCoefficient();
	FemaleCoefficient fCo = new FemaleCoefficient();

	@Override
	public Double calculateWilks(Measurements person, double liftWeight,
			boolean male) {
		double bodyWeight = person.getWeight();
		//double liftWeight = lifting.getWeight();

		//if (person.getMeasurementType() == MeasurementType.IMPERIAL) {
		//	bodyWeight = MeasurementConverter
		//			.getKilogramsFromPounds(bodyWeight);
		//	liftWeight = MeasurementConverter
		//			.getKilogramsFromPounds(liftWeight);
		//}

		double coefficient = getCoefficient(male, person);

		double wilkScore = coefficient * MeasurementConverter.getKilogramsFromPounds(liftWeight);
		// store to DB
		return wilkScore;
	}

	@Override
	public Double calculateBodyMassIndex(Measurements person) {
		Double bodyWeight = person.getWeight();
		Double bodyHeight = person.getHeight();
		Double bmi = null;

		if (checkValid("Body Weight", bodyWeight)) {
			if (checkValid("Body Height", bodyHeight)) {
				//if (person.getMeasurementType() == MeasurementType.IMPERIAL) {
					bodyWeight = MeasurementConverter
							.getKilogramsFromPounds(bodyWeight);
					bodyHeight = MeasurementConverter
							.getCentFromInch(bodyHeight);
				//}
				// change to meters
				bodyHeight = bodyHeight / 100;

				bmi = bodyWeight / Math.pow(bodyHeight, 2);
			}
		}

		return bmi;
	}

	private double getCoefficient(boolean male, Measurements person) {
		double coefficient;
		if (male) {
			coefficient = mCo.getCoefficient(person);
		} else {
			coefficient = fCo.getCoefficient(person);
		}
		return coefficient;
	}

	private boolean checkValid(String type, Double val) {
		if (val != null) {
			return true;
		}
		// TODO refactor with LOGGER
//		System.out.println(type
//				+ " was assigned a null value, retry with a valid value");
		return false;
	}
	
	/*
	 * Taken from http://www.davedraper.com/bodyfat-calculation.html
	*/
	@Override
	public Double calculateLeanBodyMass(Measurements person, boolean male) {
		Double waist = person.getWaist();
		Double weight = person.getWeight();
		
//		if (checkValid("Body Weight", weight)){
//			if (checkValid("Body Width", waist)){
//				if (person.getMeasurementType() == MeasurementType.METRIC){
//					waist = MeasurementConverter.getInchFromCent(waist);
//					weight = MeasurementConverter.getPoundFromKilograms(weight);
//				}
//			}
//			else {
//				//LOGGER
//			}
//		}
//		else {
//			//LOGGER
//		}
		
		Double fatPercentage;
		
		if (male){
			Double result1 = weight * 1.082 + 94.42;
			Double result2 = result1 - (waist * 4.15);
			//fatPercentage = (weight - result2);
			fatPercentage = result2;
		}
		else{
			Double wrist = person.getWrist();
			Double hip = person.getHip();
			Double forearm = person.getForearm();
			
//			if (checkValid("Wrist Width", wrist)){
//				if (checkValid("Hip Width", hip)){
//					if (checkValid("Forearm Width", forearm)){
//						if (person.getMeasurementType() == MeasurementType.METRIC){
//							wrist = MeasurementConverter.getInchFromCent(wrist);
//							forearm = MeasurementConverter.getInchFromCent(forearm);
//							hip = MeasurementConverter.getInchFromCent(hip);
//						}
//					}
//					else{
//						//LOGGER
//					}
//				}
//				else {
//					//LOGGER
//				}
//			}
//			else {
//				//LOGGER
//			}
			
			Double result1 = weight * .732;
			Double result2 = result1 + 8.987;
			Double result3 = wrist / 3.14;
			Double result4 = waist * .157;
			Double result5 = hip * .249;
			Double result6 = forearm * .434;
			Double result7 = result2 + result3;
			Double result8 = result7 - result4;
			Double result9 = result8 - result5;
			//fatPercentage = weight - (result9 + result6);
			fatPercentage = result9 + result6;
		}
		
		return fatPercentage;
	}

	/*
	 * Taken from http://www.davedraper.com/bodyfat-calculation.html
	*/
	@Override
	public Double calculateBodyFatPercentage(Measurements person, boolean male) {
		Double fatPercentage = calculateLeanBodyMass(person, male);
		
		Double weight = person.getWeight();
		
//		if (checkValid("Body Weight", weight)){
//				if (person.getMeasurementType() == MeasurementType.METRIC){
//					weight = MeasurementConverter.getPoundFromKilograms(weight);
//			}
//		}
//		else {
//			//LOGGER
//		}
//		System.out.println(fatPercentage);
//		fatPercentage *= 100;
//		
//		fatPercentage = fatPercentage / weight;
		fatPercentage = ((weight - fatPercentage) * 100) / weight; 
		return fatPercentage;
	}
}
