package com.psu.SWENG500.Powerlifting.interfaces;

import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.interfaces.View;

public abstract class CalculatorView implements View{
	public abstract Double calculateWilks(Measurements person, double weightLifted, boolean male);
	
	public abstract Double calculateBodyFatPercentage(Measurements person, boolean male);
	
	public abstract Double calculateLeanBodyMass(Measurements person, boolean male);
	
	public abstract Double calculateBodyMassIndex(Measurements person);
}
