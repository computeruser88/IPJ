package com.psu.SWENG500.Powerlifting.models;

import java.util.Date;

/**
 * @author Jason
 * 
 *         Abstract Class that holds measurement info, this contains values for
 *         the height and weight, both may not need to be used depending on what
 *         calculation is being called. Also includes a measurement type for
 *         whether Imperial or Metric is used
 *
 */
public abstract class Measurements {
	private int userId;
	private Double height;
	private Double waist;
	private Double neck;
	private Double hip;
	private Double wrist;
	private Double forearm;
	private Double weight;
	protected MeasurementType measurementType;
	private Date measurementDate;
	
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getHip() {
		return hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	public Double getWrist() {
		return wrist;
	}

	public void setWrist(Double wrist) {
		this.wrist = wrist;
	}

	public Double getForearm() {
		return forearm;
	}

	public void setForearm(Double forearm) {
		this.forearm = forearm;
	}

	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public Double getNeck() {
		return neck;
	}

	public void setNeck(Double neck) {
		this.neck = neck;
	}

}
