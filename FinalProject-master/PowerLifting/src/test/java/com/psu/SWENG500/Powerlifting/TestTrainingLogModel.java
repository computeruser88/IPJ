package com.psu.SWENG500.Powerlifting;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.*;

public class TestTrainingLogModel extends TestCase
{
	private TrainingLogModel trainingLog;
	
	public void setUp() throws Exception
	{
		List<Workout> tempWorkouts = new ArrayList<Workout>();
		
		Date tempStartDate = Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(tempStartDate); 
		c.add(Calendar.DATE, 1);
		Date tempEndDate = c.getTime();
		
		Workout tempWorkout1 = new Workout();
		tempWorkout1.setDescription("This is my first workout!");
		tempWorkout1.setWorkoutDate(tempStartDate);
		
		WorkoutSet set1 = new WorkoutSet();
		set1.setExercise("Exercise 1");
		set1.setRepCount(5);
		set1.setWeightLifted(50);
		
		WorkoutSet set2 = new WorkoutSet();
		set2.setExercise("Bench Press, Barbell");
		set2.setRepCount(5);
		set2.setWeightLifted(50);
		
		WorkoutSet set5 = new WorkoutSet();
		set5.setExercise("Back Extension");
		set5.setRepCount(5);
		set5.setWeightLifted(50);
		
		tempWorkout1.addSet(set1);
		tempWorkout1.addSet(set2);
		tempWorkout1.addSet(set5);
		
		Workout tempWorkout2 = new Workout();
		tempWorkout2.setDescription("This is my second workout!");
		tempWorkout2.setWorkoutDate(tempEndDate);
		
		WorkoutSet set3 = new WorkoutSet();
		set3.setExercise("Exercise 1");
		set3.setRepCount(10);
		set3.setWeightLifted(20);
		
		WorkoutSet set4 = new WorkoutSet();
		set4.setExercise("Bench Press, Barbell");
		set4.setRepCount(10);
		set4.setWeightLifted(20);
		
		tempWorkout2.addSet(set3);
		tempWorkout2.addSet(set4);
		
		tempWorkouts.add(tempWorkout1);
		tempWorkouts.add(tempWorkout2);
		
		trainingLog = new TrainingLogModel(tempWorkouts);
	}
	
	public void testGetWorkoutOnSpecificDate() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Workout workout = trainingLog.GetWorkout(sdf.parse("2/18/2017"));
		assertNull(workout);
	}
	
	public void testGetWorkoutBetweenDates() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Workout> workouts = trainingLog.GetWorkouts(sdf.parse("2/17/2017"), sdf.parse("2/18/2017"));
		assertTrue(workouts.isEmpty());
	}
	
	public void testGetWorkoutTotalByExercise()
	{
		double total = trainingLog.GetWorkoutTotalByExercise("Exercise 1").stream()
				.mapToDouble(ws -> ws.getTotalVolumeByExercise("Exercise 1"))
				.sum();
		assertEquals(450.0, total, 0);
	}
	
	public void testGetWorkoutsByExercise()
	{
		List<Workout> tempWorkouts = trainingLog.GetWorkoutsByExercise("Back Extension");
		assertEquals(1, tempWorkouts.size());
	}
}