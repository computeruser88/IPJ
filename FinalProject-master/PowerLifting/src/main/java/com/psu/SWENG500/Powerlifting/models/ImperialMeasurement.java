package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 * Metric measurement for storing personal information to be calculated
 *
 */

public class ImperialMeasurement extends Measurements {

	public ImperialMeasurement() {
		measurementType = MeasurementType.IMPERIAL;
	}

	/**
	 * @param height
	 * @param weight
	 * @param waist
	 */
	public ImperialMeasurement(double height, double weight, double waist) {
		setHeight(height);
		setWaist(waist);
		setWeight(weight);
		measurementType = MeasurementType.IMPERIAL;
	}
	
	/**
	 * @param height
	 * @param weight
	 * @param waist
	 * @param wrist
	 * @param hip
	 * @param forearm
	 */
	public ImperialMeasurement(double height, double weight, double waist, double wrist, double hip, double forearm){
		setHeight(height);
		setWaist(waist);
		setWeight(weight);
		setForearm(forearm);
		setHip(hip);
		setWrist(wrist);
		measurementType = MeasurementType.IMPERIAL;
	}
}
