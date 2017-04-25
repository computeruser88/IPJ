package com.psu.SWENG500.Powerlifting.models;

public class WorkoutSet
{
	private int workoutSetId;
	private int setNumber;
	private double weightLifted;
	private int repCount;
	private boolean isNewPR;
	private String exerciseName;
	private boolean isPartOfTotal;
	
	public WorkoutSet()
	{
	}
	
	public int getWorkoutSetId()
	{
		return this.getWorkoutSetId();
	}
	
	public void setWorkoutSetId(int workoutSetId)
	{
		this.workoutSetId = workoutSetId;
	}
	
	public int getSetNumber()
	{
		return this.setNumber;
	}

	public void setSetNumber(int setNumber)
	{
		this.setNumber = setNumber;
	}

	public double getWeightLifted()
	{
		return this.weightLifted;
	}

	public void setWeightLifted(double weightLifted)
	{
		this.weightLifted = weightLifted;
	}

	public int getRepCount()
	{
		return this.repCount;
	}

	public void setRepCount(int repCount)
	{
		this.repCount = repCount;
	}

	public boolean getIsNewPR()
	{
		return this.isNewPR;
	}

	public void setIsNewPR(boolean isNewPR)
	{
		this.isNewPR = isNewPR;
	}

	public String getExerciseName()
	{
		return this.exerciseName;
	}

	public void setExercise(String exerciseName)
	{
		this.exerciseName = exerciseName;
	}
	
	public boolean isPartOfTotal()
	{
		if (this.exerciseName.startsWith("Bench Press, Barbell") || this.exerciseName.startsWith("Deadlift, Barbell") || this.exerciseName.startsWith("Squat, Barbell"))
			return true;
		else
			return false;
	}
}