package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 * Metric measurement for storing personal information to be calculated
 *
 */
public class MetricMeasurement extends Measurements{

	public MetricMeasurement (){
		measurementType = MeasurementType.METRIC;
	}
	
	/**
	 * @param height
	 * @param weight
	 * @param waist
	 */
	public MetricMeasurement(double height, double weight, double waist){
		setHeight(height);
		setWeight(weight);
		setWaist(waist);
		measurementType = MeasurementType.METRIC;
	}
	
	/**
	 * @param height
	 * @param weight
	 * @param waist
	 * @param wrist
	 * @param hip
	 * @param forearm
	 */
	public MetricMeasurement(double height, double weight, double waist, double wrist, double hip, double forearm){
		setHeight(height);
		setWaist(waist);
		setWeight(weight);
		setForearm(forearm);
		setHip(hip);
		setWrist(wrist);
		measurementType = MeasurementType.METRIC;
	}
}
