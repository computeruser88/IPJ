package com.psu.SWENG500.Powerlifting.controller;

import java.util.Date;

import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class TrainingLogController {
	
	private Workout workout = new Workout();
	
	public TrainingLogController(){
	}
	
	public TrainingLogController(Date workoutDate){
		workout = new Workout(workoutDate);
	}
	
	public Workout getWorkout() {
		return workout;
	}
	
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	public void addWorkoutSet(WorkoutSet set){
		workout.addSet(set);
	}
	
	public int getSet(){
		System.out.println(workout + " workoutCalled");
		return workout.getNumberSets();
	}
	
	public Boolean setGoal() {
		return false;
	}
}
