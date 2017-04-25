package com.psu.SWENG500.Powerlifting.models;

import java.util.ArrayList;
import java.util.List;

import com.psu.SWENG500.Powerlifting.models.converters.MeasurementConverter;

public abstract class Coefficient {
	List<Double> variables = new ArrayList();

	public Double getCoefficient(Measurements measurements) {
		double weight = measurements.getWeight();
		//if(measurements.getMeasurementType() == MeasurementType.IMPERIAL){
			weight = MeasurementConverter.getKilogramsFromPounds(weight);
		//}
		
		Double total = new Double(0);

		int temp = 0;

		for (Double variable : variables) {
			if (temp == 0) {
				total += variable;
			} else {
				total += variable * Math.pow(weight, temp);
			}
			temp++;
		}
		total = 500 / total;
		return total;
	}
}
