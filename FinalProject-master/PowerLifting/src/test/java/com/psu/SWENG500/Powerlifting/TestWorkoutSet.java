package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class TestWorkoutSet extends TestCase
{
	private WorkoutSet workoutSession;

	public void testSetNumber()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setSetNumber(0);
		assertEquals(0, workoutSession.getSetNumber());
	}
	
	public void testWeightLifted()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setWeightLifted(100);
		assertEquals(100, workoutSession.getWeightLifted(), 0);
	}
	
	public void testRepCount()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setRepCount(1);
		assertEquals(1, workoutSession.getRepCount());
	}
	
	public void testIsNewPR()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setIsNewPR(true);
		assertEquals(true, workoutSession.getIsNewPR());
	}
	
	public void testNullExercise()
	{
		//workoutSession = new WorkoutSet();
		//workoutSession.setExercise(new Exercise());
		//assertNotNull(workoutSession.getExercise());
	}
}