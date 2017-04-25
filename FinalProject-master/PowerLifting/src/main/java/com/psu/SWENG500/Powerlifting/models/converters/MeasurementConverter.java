package com.psu.SWENG500.Powerlifting.models.converters;

/**
 * @author Jason
 * 
 *         Converter class to convert inputs from Imperial to Metric and vice
 *         versa
 */
public class MeasurementConverter {

	private static Double KILOGRAM = new Double(0.45359237);
	private static Double CENTIMETER = new Double(0.393701);

	public static double getPoundFromKilograms(double weight) {
		weight = KILOGRAM / weight;
		return weight;
	}

	public static double getKilogramsFromPounds(double weight) {
		weight = KILOGRAM * weight;
		return weight;
	}

	public static double getInchFromCent(double height) {
		height = height * CENTIMETER;
		// System.out.println("Height " + height);
		return height;
	}

	public static double getCentFromInch(double height) {
		height = height / CENTIMETER;
		// System.out.println("Height " + height);
		return height;
	}
}
