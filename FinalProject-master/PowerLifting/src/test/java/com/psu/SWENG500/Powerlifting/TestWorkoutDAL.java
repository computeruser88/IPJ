package com.psu.SWENG500.Powerlifting;

import java.sql.SQLException;
import java.util.*;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.dal.*;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestWorkoutDAL extends TestCase
{
	private Workout testWorkout;
	private static final String TEST_DB = "C:\\temp";
	
	public void setUp() throws Exception
	{
		testWorkout = new Workout();
		testWorkout.setDescription("This is my first workout!");
		testWorkout.setWorkoutDate(Calendar.getInstance().getTime());
	}
	
//	@Test
//	public void TestCreateWorkout()
//	{
//		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
//		Workout w = null;
//		try
//		{
//			w = dao.CreateWorkout(testWorkout, 38);
//		} catch (SQLException e)
//		{
//			fail(e.getLocalizedMessage());
//		}
//		Assert.assertNotNull(w);
//	}
	
	public void testGetWorkout()
	{
		//IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
		//Workout w = null;
		//try
		//{
		//	w = dao.GetWorkout(75);
		//} catch (SQLException e)
		//{
//		//	fail(e.getLocalizedMessage());
		//}
		//assertNotNull(w);
	}
	
	public void testGetWorkoutNotFound()
	{
		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
		Workout w = null;
		try
		{
			w = dao.GetWorkout(20);
		} catch (SQLException e)
		{
//			fail(e.getLocalizedMessage());
		}
		assertNull(w);
	}
	
	//TODO Redo Test to reset previous work
//	public void testGetWorkoutsForUser()
//	{
//		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
//		List<Workout> workouts = new ArrayList<Workout>();
//		try
//		{
//			workouts = dao.GetWorkouts(38);
//		} catch (SQLException e)
//		{
////			fail(e.getLocalizedMessage());
//		}
//		assertEquals(2, workouts.size());
//	}
	
	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}
}