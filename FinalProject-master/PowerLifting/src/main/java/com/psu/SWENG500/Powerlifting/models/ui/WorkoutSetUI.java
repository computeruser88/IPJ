package com.psu.SWENG500.Powerlifting.models.ui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WorkoutSetUI
{
	private SimpleIntegerProperty setNumber = new SimpleIntegerProperty();
	private SimpleDoubleProperty  weightLifted = new SimpleDoubleProperty();
	private SimpleIntegerProperty  repCount = new SimpleIntegerProperty();
	private SimpleStringProperty exercise = new SimpleStringProperty();
	
	public WorkoutSetUI(int set, double weight, int rep, String exercise)
	{
		this.setNumber.setValue(set);
		this.weightLifted.setValue(weight);
		this.repCount.setValue(rep);
		this.exercise.setValue(exercise);
	}

	public int getSetNumber()
	{
		return this.setNumber.getValue();
	}

	public double getWeightLifted()
	{
		return this.weightLifted.getValue();
	}

	public int getRepCount()
	{
		return this.repCount.getValue();
	}
	
	public String getExercise()
	{
		return this.exercise.getValue();
	}
}