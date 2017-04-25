package com.psu.SWENG500.Powerlifting.models;

import java.util.*;

public class Workout
{
	private int workoutId;
	private String description;
	private Date workoutDate;
	private List<WorkoutSet> workoutSets;
	
	public Workout()
	{
		this.workoutSets = new ArrayList<WorkoutSet>();
	}
	
	public Workout(Date workoutDate)
	{	
		this.workoutSets = new ArrayList<WorkoutSet>();
		this.setWorkoutDate(workoutDate);
	}
	
	public int getWorkoutId()
	{
		return this.workoutId;
	}
	
	public void setWorkoutId(int workoutId)
	{
		this.workoutId = workoutId;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Date getWorkoutDate()
	{
		return this.workoutDate;
	}
	
	public void setWorkoutDate(Date workoutDate)
	{
		this.workoutDate = workoutDate;
	}
	
	public void addSet(WorkoutSet set)
	{
		this.workoutSets.add(set);
	}
	
	public void deleteSet(WorkoutSet set)
	{
		this.workoutSets.remove(set);
	}
	
	public int getNumberSets()
	{
		if (workoutSets.isEmpty() || workoutSets == null){
			System.out.println("null");
			return 0;
		}
		return workoutSets.size();
	}
	
	public int getTotalExercises()
	{
		//return this.exercises.size();
		return 0;
	}
	
	public double getTotalVolume()
	{
		return this.workoutSets.stream()
				.mapToDouble(ws -> ws.getRepCount() * ws.getWeightLifted())
				.sum();
	}
	
	public double getWilksVolume()
	{
		return this.workoutSets.stream()
				.filter(ws -> ws.isPartOfTotal())
				.mapToDouble(ws -> ws.getRepCount() * ws.getWeightLifted())
				.sum();
	}
	
	public double getTotalVolumeByExercise(String exerciseName)
	{
		return this.workoutSets.stream()
				.filter(ws -> ws.getExerciseName().equals(exerciseName))
				.mapToDouble(ws -> ws.getRepCount() * ws.getWeightLifted())
				.sum();
	}
	
	public double getMaxVolumeByExercise(String exerciseName)
	{
		return this.workoutSets.stream()
				.filter(ws -> ws.getExerciseName().equals(exerciseName))
				.mapToDouble(ws -> ws.getWeightLifted())
				.max().getAsDouble();
	}
	
	public List<WorkoutSet> GetWorkoutSets()
	{
		return this.workoutSets;
	}
	
	public void SetWorkoutSets(List<WorkoutSet> workoutSets)
	{
		this.workoutSets = workoutSets;
		
	}
}